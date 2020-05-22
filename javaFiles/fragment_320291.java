int i = 0;
while (s != null){
    id[i] = Integer.parseInt(s.substring(0, 5));
    System.out.println(id[i]);
    s = in.readLine();
    i++;    
}