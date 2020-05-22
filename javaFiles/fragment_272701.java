String numberAsWord =  EnglishNumberToWords.convert()     //The Method from the site
String numberAsRank = null;
if(numberAsWord.equals("one){
numberasRank = "first";
}else if(numberAsWord.equals("two"){
...
}else{
numberasRank = numberAsWord + "th"
}