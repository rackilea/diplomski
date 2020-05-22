sc.useDelimiter(System.getProperty("line.separator"));
while(sc.hasNext()) {
    String line=sc.next();
    String [] fields = line.split(";");
    System.out.println(fields[4]);
}