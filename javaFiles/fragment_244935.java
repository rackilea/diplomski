int firstValue = 0;      // initialize a first value (always used)
int secondValue = 0;     // initialize a second value (may or may not be used)

if(lineArr.length == 1){
        // parse just the first element. That's all we need.
        firstValue = Integer.parseInt(lineArr[0]);  
        // do stuff here...
}
if(lineArr.length == 2){
        // parse both elements.  We need both, right?
        firstValue = Integer.parseInt(lineArr[0]);
        lineArr[1] = lineArr[1].trim();  // remove any leading whitespaces!
        secondValue = Integer.parseInt(lineArr[1]);
        // do stuff here...
}