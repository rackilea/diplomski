// loop over files you want to change
for (int i = 1; i < 1000; i++) {
   FileReader f0 = new FileReader(i + ".html");
   StringBuilder sb = new StringBuilder();
   BufferedReader br = new BufferedReader(f0);
   while((temp1=br.readLine())!=null) { 
      sb.append(temp1); 
   }
   String para = sb.toString().replaceAll("<br>","\n");
   String textonly = Jsoup.parse(para).text();
   System.out.println(textonly);
   // stick .txt on the end of the filename to write out
   FileWriter f1=new FileWriter(i + ".txt"); 
   char buf1[] = new char[textonly.length()];
   textonly.getChars(0,textonly.length(),buf1,0);
   for(i=0;i<buf1.length;i++) {
      if(buf1[i]=='\n') {
         f1.write("\r\n");
      }
      f1.write(buf1[i]);
   }