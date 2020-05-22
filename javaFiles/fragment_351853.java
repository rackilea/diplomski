int i=0;
while(temp.hasNextLine())
{
    String line = temp.nextLine();
    for (int j = 0; j < cols; j++)
        {
            if(x == line.charAt(j))
            { 
                treasureLocations[location] = new Coord(i, j);
                location++;
            }
        }
    }
    ++i;
}