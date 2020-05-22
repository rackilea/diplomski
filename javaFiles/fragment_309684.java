public class PathEdge {


    static final String REMOTE = "remote:localhost/";

    static final String NOMEDB  = "ShortestPath2";
    static final String CURRENTPATH = REMOTE + NOMEDB;

public static void main(String[] args) throws IOException {

    OServerAdmin serverAdmin = new OServerAdmin(CURRENTPATH).connect("root", "root");

    OrientGraphNoTx g = new OrientGraphFactory(CURRENTPATH).getNoTx();

    String Vstart   = "a";  //----- to set
    String Vend     = "d";  // ---- to set
    String queryClassName   = "Nodo";  //----- to set
    String queryProperty    = "name"; //----- to set
    String edgeNAme = "is_a";   //----- to set
    String direction = "'OUT'";  //----- to set "BOTH" (incoming and outgoing), "OUT" (outgoing) and "IN" (incoming)

    String query1 = "select from "+queryClassName+" where "+queryProperty+" = '"+Vstart+"'";
    Iterable<Vertex> start = g.command(new OSQLSynchQuery<Vertex>(query1)).execute();

    String query2 = "select from "+queryClassName+" where "+queryProperty+" = '"+Vend+"'";  
    Iterable<Vertex> end = g.command(new OSQLSynchQuery<Vertex>(query2)).execute();

    long startTime = System.currentTimeMillis();
    showPath(g, start.iterator().next().getId().toString(), end.iterator().next().getId().toString(), edgeNAme, direction);
    long estimatedTime = System.currentTimeMillis() - startTime;
    System.out.println("");
    System.out.println("TIME EXECUTE: "+estimatedTime+"ms");
}

public static void showPath (OrientGraphNoTx  g, String Vstart, String Vend , String edge, String direction) {

     String s = "";
     int position = 0;
     int maxsize = 0;

     s= "select expand(shortestPath(" + Vstart + ", " + Vend+", "+direction+"))";

    Iterable<Vertex> result = g.command(new OSQLSynchQuery<Vertex>(s)).execute();
    List<OrientVertex> listaVertex = new ArrayList<OrientVertex>();
    CollectionUtils.addAll(listaVertex, result.iterator());

    List<String> listPRECout = new ArrayList<String>();
    List<String> listPRECin = new ArrayList<String>();
    List<String> listFOLLout = new ArrayList<String>();
    List<String> listFOLLin = new ArrayList<String>();

    List<String> resultOut = new ArrayList<String>();
    List<String> resultIn = new ArrayList<String>();

    //per ogni vertice recupera archi uscenti ed entranti
    Iterable<Edge> tempOut;
    Iterable<Edge> tempIn;
    String singleIn = "";
    String singleOut = "";
    boolean finded = false;

    System.out.println("SHORTEST PATH (vertex [direction "+direction+"]):");
    for (int v=0; v<listaVertex.size(); v++) {
        System.out.print(listaVertex.get(v).getProperty("name")+ " " );
    }
    System.out.println("");
    System.out.println("");
    maxsize = listaVertex.size()-1;
    for (int v=0; v<maxsize; v++) {

        //--------FIRST VERTEX OF THE SHORTEST PATH
        tempOut = listaVertex.get(v).getEdges(Direction.OUT, edge);
        tempIn = listaVertex.get(v).getEdges(Direction.IN, edge);

        //set listPRECin 
        for(Edge edgeIn : tempIn) {
            listPRECin.add(edgeIn.getId().toString());  //position x   = rid
            listPRECin.add(edgeIn.getLabel());          //position x+1 = label
        }

        //set listPRECout 
        for(Edge edgeOut : tempOut) {
            listPRECout.add(edgeOut.getId().toString());  //position x   = rid
            listPRECout.add(edgeOut.getLabel());          //position x+1 = label
        }

        //--------SECOND VERTEX OF THE SHORTEST PATH
        tempOut = listaVertex.get(v+1).getEdges(Direction.OUT, edge);
        tempIn = listaVertex.get(v+1).getEdges(Direction.IN, edge);

        //set listFOLLin 
        for(Edge edgeIn : tempIn) {
            listFOLLin.add(edgeIn.getId().toString());  //position x   = rid
            listFOLLin.add(edgeIn.getLabel());          //position x+1 = label
        }

        //set listFOLLout 
        for(Edge edgeOut : tempOut) {
            listFOLLout.add(edgeOut.getId().toString());  //position x   = rid
            listFOLLout.add(edgeOut.getLabel());          //position x+1 = label
        }


        //------MATCH LOGIC
        //...compare PRECin with FOLLout
        finded = false;
        for(int i = 0; i<listPRECin.size(); i=i+2) {
            singleIn = listPRECin.get(i);
            for(int o = 0; o<listFOLLout.size(); o=o+2){
                singleOut = listFOLLout.get(o);
                if(singleIn.equals(singleOut)) {

                    //check is there a hole
                    if(v==0) {
                        resultIn.add(singleIn);  //rid
                        resultIn.add(listPRECin.get(i+1)); //label
                        finded = true;
                        break; 
                    } else if((v*2) == resultIn.size()) {
                        resultIn.add(singleIn);  //rid
                        resultIn.add(listPRECin.get(i+1)); //label
                        finded = true;
                        break; 
                    }
                }
            }
            if(finded)break;    
        }

        finded = false;
        //...compare PRECout with FOLLin
        for(int i = 0; i<listPRECout.size(); i=i+2) {
            singleOut = listPRECout.get(i);
            for(int o = 0; o<listFOLLin.size(); o=o+2){
                singleIn = listFOLLin.get(o);
                if(singleOut.equals(singleIn)) {
                    //check is there a hole
                    if(v==0) {
                        resultOut.add(singleOut);  //rid
                        resultOut.add(listPRECout.get(i+1)); //label
                        finded = true;
                        break; 
                    } else if((v*2) == resultOut.size()) {
                        resultOut.add(singleOut);  //rid
                        resultOut.add(listPRECout.get(i+1)); //label
                        finded = true;
                        break; 
                    }
                }
            }
            if(finded)break;    
        }

        //to empty out list
        listPRECin.clear();
        listPRECout.clear();    
        listFOLLin.clear();
        listFOLLout.clear();    

        //cheack if it's in the penultimate vertex
        position = v+1;
        if( position==maxsize) {
            break;
        }

    }


    System.out.println("SHORTEST PATH (edge, out direction):");
    if(resultOut.size()>0) {
        for (int ind=0; ind<resultOut.size(); ind=ind+2) {  //ind+2 so i get id[position x] and label [position x+1] 
            System.out.println("id:"+resultOut.get(ind)+", Label:"+resultOut.get(ind+1));
        }
    } else {
        System.out.println("No edge in this direction (OUT)");
    }

    System.out.println("");
    System.out.println("SHORTEST PATH (edge, in direction):");
    if(resultIn.size()>0) {
        for (int ind=0; ind<resultIn.size(); ind=ind+2) {  //ind+2 so i get id[position x] and label [position x+1] 
            System.out.println("id:"+resultIn.get(ind)+", Label:"+resultIn.get(ind+1));
        }
    }else {
        System.out.println("No edge in this direction (IN)");
    }

}