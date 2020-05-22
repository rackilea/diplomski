while((rec = br.readLine()) != null) {
    System.out.println(rec);
    for(int i = rec.length()-1; i>=0; --i) {
        temp = temp + rec.charAt(i);
    }
    temp = temp + System.getProperty("line.separator");
}
System.out.println(temp);