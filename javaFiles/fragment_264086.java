// Other Hibernate code here
PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("D:/Users/output.txt"))); 
System.out.println("Total Number Of Records : "+((java.util.List) l).size());
Iterator it = ((java.util.List) l).iterator();    
while(it.hasNext())
   {
        writer.println(e.getId());
   } 

writer.close(); // put this in finally block