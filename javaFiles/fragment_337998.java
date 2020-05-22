import java.util.Scanner;
public class Prog4 { 

 static Scanner scanner = new Scanner(System.in);

 public static void main(String[] args) { CreditCardNumber[] cred1; CreditCardNumber cred2 = getInput(); Display("The complete number from your input:", cred2); cred1 = getInputArray(); DisplayArray(cred1); TryAnother(cred1); // pass variable cred1 as a parameter }

 public static CreditCardNumber getInput() { String ID; String accNum; CreditCardNumber tempCred; System.out.printf("Please enter issuer ID:"); ID = scanner.next(); System.out.printf("Please enter account number:"); accNum = scanner.next(); tempCred = new CreditCardNumber(ID, accNum); return tempCred; }

 public static void Display(String ch, CreditCardNumber cred2) { System.out.println(ch); System.out.println(cred2.toString().replaceAll(".{4}", "$0 ")); }

 public static CreditCardNumber[] getInputArray() { CreditCardNumber[] tempArray; String tempID; int size; System.out.printf("Please enter size of the aray:"); size = scanner.nextInt(); if(size < 1) { size = 1; } tempArray = new CreditCardNumber[size]; System.out.printf("Please enter issuer ID:"); tempID = scanner.next(); for(int i = 0; i < tempArray.length; i++) { tempArray[i] = new CreditCardNumber(); tempArray[i].CreateCred(tempID); } return tempArray; }

 public static void DisplayArray(CreditCardNumber[] cred1) { for(int i = 0; i< cred1.length; i++) { Display("Credit Card # " + i+":" + '\n', cred1[i]); } System.out.println(); }

 public static boolean TryAnother(CreditCardNumber[] cred1) // pass cred1 as a parameter { String s; System.out.printf("Get more credit card numbers? (n for no):"); s = scanner.next(); if(s.charAt(0) != 'N' || s.charAt(0) != 'n') { do { cred1 = getInputArray(); }while(s.charAt(0) != 'N' || s.charAt(0) != 'n'); } return false; // put the return statement here }

 }

 // A dummy class class CreditCardNumber{ String ID; String accNum; public CreditCardNumber(){ } public CreditCardNumber(String ID,String accNum){ this.ID = ID; this.accNum = accNum; } public void CreateCred(String tempID){ ID = tempID; } }