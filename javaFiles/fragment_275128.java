String whiconcatC = scrubbedInputArray[0];
String whiconcatD = scrubbedInputArray[1];
String whiconcatE = scrubbedInputArray[2];
String whiconcatF = "";
String whiconcatG = "";


// there MAY be a fourth or fifth element
if (scrubbedInputTokens > 3) {
whiconcatF = scrubbedInputArray[3];   
} else {
whiconcatF = " ";
}
//
if (scrubbedInputTokens > 4) {
whiconcatG = scrubbedInputArray[4];
} else {
whiconcatG = " ";
}