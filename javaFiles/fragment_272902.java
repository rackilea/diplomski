function getCharCode(displayNumber){
    var ordA = 'A'.charCodeAt(0);
    var ordZ = 'Z'.charCodeAt(0);
    var len = ordZ - ordA + 1;

    var returnSequence = "";
    while(displayNumber >= 0) {
        returnSequence = String.fromCharCode(displayNumber % len + ordA) + returnSequence; // (displayNumber % 26 + 65) +""
        displayNumber = Math.floor(displayNumber / len) - 1; //(displayNumber / 26) - 1
    }
    return returnSequence;
}