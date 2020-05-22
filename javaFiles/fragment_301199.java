Scanner input = new Scanner(myFile); //whatever file is being read

for (x=0; i<map_width; x++)
{
    for (y=0; y<map_height; y++)
    {
        int nextTile = input.nextInt(); //reads the next int
        // or
        char nextTile = input.nextChar(); //reads the next char
    }
}