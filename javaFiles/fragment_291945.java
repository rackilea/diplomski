//split all sentences and put them into an array
String[] tokens = str.trim().split("\\.");
//initialize a result string
String resultString = " ";
//loop through every sentence capitalizing the first character.
for(int i = 0; i<tokens.length; i++){
   //first trim off any whitespace that may occur after period...
   tokens[i] = tokens[i].trim();
   //then capitalize the first letter of every sentence
   tokens[i] = tokens[i].substring(0,1).toUpperCase() + tokens[i].substring(1);
   //then add the sentence with the upperCase first character to your result string
   resultString += " " + tokens[i] + ".";
}
//once out of loop, resultString has the contents of all the sentences with a capital letter to begin the sentence. Notice I use str for my string name, you use s