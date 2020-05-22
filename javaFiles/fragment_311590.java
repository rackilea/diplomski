public void computeNewCSV() {
    List<Integer> a = new LinkedList<Integer>();
    List<Integer> b = new LinkedList<Integer>();
    List<Integer> c = new LinkedList<Integer>(); 

    FileInputStream fis = new FileInputStream("input_file");
    BufferedReader br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));
    String line;
    while ((line = br.readLine()) != null) {
       String split[] = line.split(","); 
       if(split[0].equals("A") {
           a.add(Integer.parseInt(split[1]));
       } else if (split[0].equals("B") {
           b.add(Integer.parseInt(split[1]));
       } else if (split[0].equals("C") {
           c.add(Integer.parseInt(split[1]));
       }
    }
    br.close();
    fis.close();

    //Now you have the complete information to be put into the new file.

    PrintWriter writer = new PrintWriter("output-file-name", "UTF-8");
    writer.println("A,B,C");
    while(!(a.isEmpty && b.isEmpty() && c.isEmpty())) {
        StringBuilder sb = new StringBuilder("");
        if(!a.isEmpty()) {
            sb.append(a.remove(0)); 
        } 
        sb.append(",");     
        if(!b.isEmpty()) {
            sb.append(b.remove(0)); 
        } 
        sb.append(",");
        if(!c.isEmpty()) {
            sb.append(c.remove(0)); 
        } 
        writer.println(sb.toString());
    }

    writer.close();
}