public static void sortYears(Music2[] musics)
{
   int y;
   Music2 temp = new Music2("",0,"");

   for(int x = 0; x<musics.length; x++)
   {
        for( y = 1; y < musics.length-x; y++)
        {    
            if(musics[x].getYear() > musics[y-1].getYear()) {
                swap(x, y, musics);
            }
        }
   }      
}

private static void swap(int a, int b, Object[] arr) {
    Object temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
}