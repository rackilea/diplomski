public static void generateAsterisks(String[] list, int numAsteriks)
{
    for(int i = 0; i < numAsteriks && i < list.length; i++)
    {
        int index = (int)(Math.random()*list.length);

        //check if already added *
        if(list[index].lastIndexOf('*') != list[index].length()-1) {
            list[index] = list[index] + "*";
        } else {
            //don't count this loop iteration
            i--;
        }
    }
}