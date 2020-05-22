char1 = hexRGB.getCheck_hex2();
char2 = hexRGB.getCheck_hex4();
//assuming char1 and char2 are the same size and symmetrical
String[][] combine = new String[char1.length][char1[0].length]

for (int i = 0; i < char1.length; i++) 
{
    for(int j = 0; j < char1[i].length; j++)
    {
         // This will only concatenate the strings though,
         // If you want the numerical addition you will have to 
         // convert them to ints first
         combine[i][j] = char1[i][j] + char2[i][j];
    }
}