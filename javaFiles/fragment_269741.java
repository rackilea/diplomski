//imports
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

//create the array lists to save the data
private static List<String> readData = new ArrayList<String>();
private static List<String> readTerms = new ArrayList<String>();
private static List<String> splitData = new ArrayList<String>();
private static List<String> finalData = new ArrayList<String>();

public static void main(String[] args) throws Exception{
   readData();
   processData();
   writeFinalData();
}

public static void readData() throws Exception{
//create readers
BufferedReader data = new BufferedReader(new FileReader(new File("Test.csv")));
BufferedReader term = new BufferedReader(new FileReader(new File("Terms.txt")));

//read the data and save it into the array lists
String line;
while((line = term.readLine()) != null){
   readTerms.add(line);
}

while((line = data.readLine()) != null){
   readData.add(line);
}

//close the readers
data.close();
term.close();
}