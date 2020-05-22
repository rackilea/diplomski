boolean pabaiga_ciklo = false;
int [ ] [ ] matrix = new double [ 8 ] [ 16 ] ;
while (!pabaiga_ciklo) 
{
    System.out.println("");
    System.out.println("Suma. When result: " + V);

    int row = 0;
    for (int i=2; i<257; i=i*2 )
    {
          V = i+V;              
          System.out.println("Suma: " + V + " when added:: " + i);  
          matrix[0][row] = V;
          row++;
    } 


    V = (int) ((Math.PI * Math.pow(H, 4) * (Math.pow(R, 2)
            + Math.pow(r, 2) + Math.pow(r, 5) * Math.pow(r, 3))) / 3);


    System.out.println("");
    System.out.println("subtraction. With result: " + V);
    row = 8;
    for (int i=2; i<257; i=i*2 )
    {
          V = V-i;
          System.out.println("Suma: " +V+ " when subtracted: "+i);
          matrix[0][row] = V;
          row++;
    }     
}

for (int i = 0; i < 8; i++) {
    System.out.print((i + 1) + " ");
    for (int j = 0; j < 16; j++) {
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println();
}