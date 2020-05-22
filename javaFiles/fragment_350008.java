public static ArrayList<String> returnMaterialDesignColorSet(String baseColorHex, int colorCount) {
    ArrayList<String> resultList = new ArrayList<String>();
     float [] baseColorHSL = colorToHsl(baseColorHex);

    float lght=0.4;// initial lightness value (experimental)
    float lStep=(0.6 - lght) / colorCount; // step to go up to 0.6 lightness (experimental)
    for (int i = 0; i < colorCount; i++) {
         String baseColor = hslToColor(1 ,baseColorHSL[0] , baseColorHSL[1] , lght);
         resultList.add(baseColor);
         lght += lStep;
    }

    return resultList;
}