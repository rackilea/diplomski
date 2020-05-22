Scanner scan = new Scanner(System.in);
   int aux = 1;
   while(aux<=n)   {
       System.out.print("Serie Nº" +aux +"  []");
       scan.nextLine();
       System.out.println("Serie Nº" +aux +"  [X]");
       cuenta();
       aux++;
    }