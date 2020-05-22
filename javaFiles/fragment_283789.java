private void testMyMethod(){
    String resultString = "";
    int[] array = { 0, 3, 1, -2, 0, -1, 1, 1, -2 };

    for(int step : array){
        String direction = convertToDirection(step);
        // Adding a comma -- as you requested
        // just add this in case you what to indicate a start point ==> X
        if(direction.isEmpty()){
            resultString = resultString.concat("X");
        }
        else{
            resultString = resultString.concat(direction);
        }
        resultString = resultString.concat(",");
    }
    resultString = resultString.subString(0, resultString.length()-1);
    myTextView.setText(resultString);
}

private String convertToDirection(int step){
    String direction = "";

    if(step > 0){
        direction = "e";
    }
    else if(step < 0){
        direction = "w";
    }

    String result = "";
    int len = Math.abs(step);

    for(int i = 0; i < len; i++){
        result = result.concat(direction);
    }

    return result;
}