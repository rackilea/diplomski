//Create FileWriter to write text to the text file
FileWritrer charName = new FileWriter("CharacterName.txt");
charName.write("Text needing to be saved goes in here");
charName.close();

//Creates BufferedReader to get data from txt file and save the line read in a variable
BufferedReader br = new BufferedReader(new FileReader("write.txt"));
String lineRead= br.readLine();//storing read line in variable for later use
System.out.println("The text in the first line goes here:\n"+ lineRead);
br.close();