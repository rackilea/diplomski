if(lineArr.length == 1){
        // parse just the first element. That's all we need.
        firstValue = Integer.parseInt(lineArr[0]);  
        // do stuff here...
}
if(lineArr.length > 1){
        firstValue = Integer.parseInt(lineArr[0]);
        for (int i = 1; i < lineArr.length; ++i) {
            if (!lineArr[i].equals("")) {
                secondValue = Integer.parseInt(lineArr[i]);
            }
        }
        // do stuff here with firstValue and secondValue
}