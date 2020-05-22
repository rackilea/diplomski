try {
    ArrayList<String> list = new ArrayList<String>();
    File dir = new File("path of folder that contains my files")

    for (File f : dir.listFiles()) {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
        String line = null;
        while((line = br.readLine())!= null) {
            String [] tokens = line.split(",\\s+|\\s*\\\"\\s*|\\s+|\\.\\s*|\\s*\\:\\s*");
            for(int i=0; i<tokens.length(); i++)
            {  //Adding non-duplicates to arraylist
               if (!list.contains(tokens[i])  
               {
                   list.add(tokens[i]);
               }
            }
        }
        Collections.Sort(list);
    }
}
catch(Exception ex){}