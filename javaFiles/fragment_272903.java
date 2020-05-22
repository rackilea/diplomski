function getCharCode(displayNumber){
    var returnSequence = "";
    while(displayNumber >= 0) {
        returnSequence = String.fromCharCode(displayNumber % 26 + 65) + returnSequence;
        displayNumber = Math.floor(displayNumber / 26) - 1;
    }
    return returnSequence;
}