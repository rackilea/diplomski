public static  String xhtmlparser(){ 
    String Cleanline="";

    try { 
        // the file url
        FileInputStream fstream = new FileInputStream("c.xhtml");
        // Use DataInputStream to read binary NOT text.
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine = null;
        int linescounter=0;
        while ((strLine = br.readLine()) != null)   {// read every line in the file             
            String m=strLine.replaceAll("&nbsp;", "");
            linescounter++;
            if(linescounter==5)
                m=m+"\n"+ "<link rel="+ "\"stylesheet\" "+"type="+ "\"text/css\" "+"href= " +"\"tableStyle.css\""+ "/>";
            Cleanline+=m+"\n";
        }

    }
    catch(IOException e){}

    return Cleanline;
}