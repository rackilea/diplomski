import java.io.File;
 import java.util.Scanner;

 public class PhishingScanner {

 // list of phishing words
 private static final String[] phishingWords = { "DHL", "official",
    "bank", "security", "urgent", "alert", "important", "delivery",
    "ebay", "taxes", "credit", "verify", "confirm", "account",
    "bill", "immediately", "address", "telephone", "ssn", "charity",
    "check", "personal", "confidential", "atm", "warning",
    "fraud", "won", "irs", "owe", "pay" };

  // parallel array of point values
 private static final int phishingPoints[] = { 2, 2, 1, 1, 1, 1, 1, 2, 3, 3,
    3, 1, 1, 1, 1, 1, 2, 2, 3, 2, 1, 1, 1, 1, 2, 2, 2, 2, 2, 1 };

public static void main(String[] args) throws Exception {

try { 
    String fileName = args[0].toString();
    Scanner file = new Scanner(new File(fileName));

    int size = phishingWords.length;
    int wordsCount[] = new int[size];

for (int i = 0; i < size; i++)
    wordsCount[i] = 0;

while (file.hasNext()) {
    String word = file.next();

    for (int i = 0; i < size; i++)
        if (word.equalsIgnoreCase(phishingWords[i]))
            wordsCount[i]++;
}

System.out.println("\nWord\t\t\tCount\tPoints\n");
int totalPoints = 0;
for (int i = 0; i < size; i++) {
    if (wordsCount[i] > 0) {
        System.out.printf("%-15s %8d %8d\n", phishingWords[i],
                wordsCount[i], phishingPoints[i]);               
        totalPoints += phishingPoints[i] * wordsCount[i];
    }
}
System.out.println("\nTotal points: " + totalPoints);
file.close();


} catch(Exception e) { 
     System.out.println("Please enter a file when running the program"); 
  System.out.println("Example: java PhishingScanner EmailFromMom.txt");

}
}//end method main

 }