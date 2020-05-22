public void Escanear() throws FileNotFoundException
{
    Scanner sc=new Scanner(new File("inicio.txt"));
    while(sc.hasNext())
    {
        String token = sc.next();

        if (token.equals("Pared"))
        {
            int i=sc.nextInt() -1;
            int j=sc.nextInt() -1;

            _mat[i][j] = new Pared(i,j);
        }

        else if(token.equals("Fantasma"))
        {
            int i=sc.nextInt() - 1;
            int j=sc.nextInt() - 1;

            _mat[i][j]= new Fantasma(i,j);
        }
    }
}