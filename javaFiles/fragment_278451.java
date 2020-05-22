BufferedReader in = new BufferedReader(new FileReader(args[0]));
   new File("./indexof"+args[0]).mkdirs();
   BufferedWriter[] outs = new BufferedWriter[26];
   SubString sub = new SubString();
   String s;
   int lineNumber = 1;
   while( (s = in.readLine()) != null ){
       s = s.replaceAll("[^\\sa-zA-Z]", "").toLowerCase();
       String[] list = s.split("\\s+");
       for( String sl: list ){
           ArrayList<String> substrings = sub.getAllUniqueSubset(sl);
           for( String sb: substrings ){
               BufferedWriter out = outs[sb.charAt(0)-'a'];
               if( out == null ){
                   out = outs[sb.charAt(0)-'a'] =
                   new BufferedWriter(new FileWriter("./indexof"+args[0]+"/"+sb.charAt(0)+".txt",true), 1024*16);
               }
               out.write(sb);
               out.write(" ");
               out.write(Integer.toString(lineNumber));
               out.newLine();
           }   
       }
       lineNumber++;
   }
   in.close();
   for( BufferedWriter out: outs ){
       if( out != null ) out.close();
   }