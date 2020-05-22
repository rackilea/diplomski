//Board into a 2d Array
for (int r = 0; r < bord.length; r++) {
     for(int a = 0; a < 11; a++)
         bord[r][a] = letters[r*11 + a];

     System.out.println(bord[r]);
}