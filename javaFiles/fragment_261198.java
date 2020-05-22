while((rec = br.readLine()) != null) {
    System.out.println(rec);
    temp = "";
    for(int i = rec.length()-1;i>=0;--i) {
        temp = temp + rec.charAt(i);
    }
   System.out.println(temp);
}