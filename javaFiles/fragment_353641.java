public Crawford_Diamond(String sN, double car, String clar, char col, String cutType)
{
    stockNumber = sN; 
    carot = car; 
    clarity = clar; 
    color = col; 
    cut = cutType;

    diamondColor = compareColor(color);
    diamondClarity = compareClarity(clarity);
}