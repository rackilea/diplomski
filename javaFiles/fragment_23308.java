for(int i = 0; i < colorArray.length; i++) {
    // use while in case the color is black/white.  (May thrash for few iterations)
    while (colorArray[i].equals(matchingColor)) {
       colorArray[i] = (Math.random() < 0.5)?colorArray[i].brighter():colorArray[i].darker();
    }
}