static void drawLayeredPyramid (int numLayers, char firstChar, char secondChar) {
    for (int i = numLayers; i > 0; i--){
        if ((i%2)==0){
            for (int j = 0; j < i; j++){
                 System.out.print(firstChar);
            }
        }
        else {
            for (int j = 0; j < i; j++){
                System.out.print(secondChar);
            }
        }
        System.out.println(); 
    }
}