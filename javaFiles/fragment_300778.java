//THIS IS AN EXAMPLE KNOWLEDGE BASE
String[] aryLines = {"Dogs have tails","Donkeys have no humps"};

//THIS IS THE QUESTION SUPPLIED BY POSTER
String question = "no tails";

//IT SEEMS THAT POSTER WANTS TO EXCLUDE CERTAIN WORDS FROM THE SEARCH
String exclude = "no";

//REMOVE ALL OCCURRENCES OF THE EXCLUDE STRING IN QUESTION
question = question.replaceAll(exclude, "");

//FOR EACH TOKEN (FROM KNOWLEDGE BASE)
for(String token : aryLines) {
    //MATCH QUESTION AGAINST TOKENS
    if (token.matches("(.*)" + question + "(.*)")) {
        System.out.println(token);
    }
}