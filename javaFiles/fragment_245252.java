public static void main(String[] args) {

        List<Assignatura> assignaturas = new ArrayList<Assignatura>();
        List<Curso> cursos = new ArrayList<Curso>();

        try{

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder loader = factory.newDocumentBuilder();

        Document document = loader.parse("datos.xml");

        DocumentTraversal traversal = (DocumentTraversal) document;

        NodeIterator iterator = traversal.createNodeIterator(   
        document.getDocumentElement(), NodeFilter.SHOW_ALL, new ListAsignaturasFilter(), true);

        for (Node n = iterator.nextNode(); n != null; n = iterator.nextNode()) {

            Element el = (Element) n;

            NodeList assignments = el.getElementsByTagName("Asignatura");

            for(int i=0; i<assignments.getLength(); i++){
                Node currentNode = assignments.item(i);
                NodeList childs = currentNode.getChildNodes();                  
                String id = getValorHijo(childs, "id");
                String nombre = getValorHijo(childs, "nombre");

                if(!id.isEmpty() || !nombre.isEmpty())
                    assignaturas.add(new Assignatura(id, nombre));          

            }       
        }

        NodeIterator itCurso = traversal.createNodeIterator(    
                document.getDocumentElement(), NodeFilter.SHOW_ALL, new CursoFilter(), true);

        for (Node n = itCurso.nextNode(); n != null; n = itCurso.nextNode()) {

            Element el = (Element) n;

            NodeList cursos = el.getChildNodes();

            String id = getValorHijo(cursos, "id");
            String nombre = getValorHijo(cursos, "nombre");

            if(!id.isEmpty() || !nombre.isEmpty())
                cursos.add(new Curso(id, nombre));
        } 

        for(Assignatura assignatura : assignaturas){
            System.out.println(assignatura);
        }

        for(Curso curso : cursos){
            System.out.println(curso);
        }

        }catch (Exception e) {
            e.printStackTrace();
        }

    }   

    private static String getValorHijo(NodeList childs, String data){

        String search="";       

        if(childs.getLength()>0)

            for(int j=0; j<childs.getLength(); j++){
                if(childs.item(j).getNodeName().equals(data)){
                    return childs.item(j).getTextContent();
                }
            }

        return search;      
    }

    private static final class ListAsignaturasFilter implements NodeFilter {
        public short acceptNode(Node n) {
          if (n instanceof Element) {
            if (((Element) n).getTagName().equals("listaAsignaturas")) {
              return NodeFilter.FILTER_ACCEPT;
            }
          }
          return NodeFilter.FILTER_REJECT;
        }
      }

    private static final class CursoFilter implements NodeFilter {
        public short acceptNode(Node n) {
          if (n instanceof Element) {
            if (((Element) n).getTagName().equals("curso")) {
              return NodeFilter.FILTER_ACCEPT;
            }
          }
          return NodeFilter.FILTER_REJECT;
        }
      }