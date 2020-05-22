try (Scanner sc = new Scanner(io))
{
    pw = new PrintWriter(os, true);
    pw.println("Connected");
    while(sc.hasNextLine())
    {
        String line = sc.nextLine();
        System.out.println("Client "+count+": "+line);
        pw.println("Echo: "+line);     
    }
}
finally {
    System.out.println("Client " + this.id + " left the session."");
}