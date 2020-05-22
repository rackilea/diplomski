public static void display(ExampleA[] example)
{ 
    for(int pos = 0; pos < example.length; pos++) 
    {   
        if(example[pos] instanceof A)
        {
            outputA += "Example number " + (i + 1);
            outputA += example[pos].toString() + "\n\n";             
        }

        if(example[pos] instanceof B)
        {
            outputB += "Example number " + (i + 1);
            outputB += example[pos].toString() + "\n\n"; 
        }

    }

    System.out.println("A:\n" + outputA);
    System.out.println("B:\n" + outputB);
}