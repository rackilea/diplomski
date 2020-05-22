FileInputStream fin =  new FileInputStream(args[i]);
  BufferedReader myInput = new BufferedReader(new InputStreamReader(fin));
  StringBuilder sb = new StringBuilder();
  while ((thisLine = myInput.readLine()) != null) {  
             sb.append(thisLine);
  }