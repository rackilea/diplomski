Scanner diskScanner = new Scanner(new File("Names.txt"));
diskScanner.useDelimiter(",");

while (diskScanner.hasNext()) 
   {
    String n = diskScanner.next();

    if(n.contains(":"))
       {
        int i = n.indexOf(":");
        list.add(new Student(Integer.parseInt(n.substring(i+1)), n.substring(0,i)));
       }
    else
        list.add(new Student(0, n));
    }