private void testMyMethod(){
    int[] array = { 0, 3, 1, -2, 0, -1, 1, 1, -2 };
    StringBuilder sb = new StringBuilder();
    for(int step : array){
        sb.append(convertToDirection(step).concat(","));
    }
    // Remove the last ","
    sb.deleteCharAt(sb.length()-1);
    myTextView.setText(sb.toString());
}

private String convertToDirection(int step){
    if(step == 0) return "0";
    String direction = step > 0 ? "w" : "e";

    int len = Math.abs(step);
    return new String(new char[len]).replace("\0", direction);
}