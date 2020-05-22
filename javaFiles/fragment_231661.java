System.out.println("digraph G {");   //  To print it once
for(int i=0;i<1;i++)
{
    for(int j=0; j<visited.length()-1; j++)  // Accessing one less node to avoid extra "->" at the end
    for (String node : visited)
    {
        System.out.print(node);
        System.out.print("->");
        out.write(node);
        out.flush();
    }
    System.out.print(node);  //Printing the last node left
    out.flush();
    out.close();

    System.out.println();
}
System.out.println("}");