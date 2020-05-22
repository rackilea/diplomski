counter = 0;
listOfColors = new colors[numColors];
while(tokens.nextToken() != tokens.TT_EOF)
{
    listOfColors[counter] = new Colors();
    listOfColors[counter].name = (String)tokens.sval; 
    tokens.nextToken();
    listOfColors[counter].r = (int)tokens.nval;
    System.out.println(listOfColors[counter].r);
    tokens.nextToken();
    listOfColors[counter].g = (int)tokens.nval;
    tokens.nextToken();
    listOfColors[counter].b = (int)tokens.nval;
    counter++;
}