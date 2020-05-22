String[] badWords = new String[5]; 
//set all of you bad words
String fname = scanner(System.in);
//check if it contains explicit words
boolean containsBadWord = false;
for(String badWord : badWords){
    if (fname.contains(badWord)) {
        containsBadWord = true;
        break;
    } 
}
if(containsBadWord){
    System.out.println(fname + " contains inappropriate words and is not accepted.");
}
else {
    System.out.println(fname + " is all good");
    //create file
    createFile(fname);
}