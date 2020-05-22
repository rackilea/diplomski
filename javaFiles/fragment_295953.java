import java.util.Scanner;

public class Main {

    public static void main (String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a phrase.");
        String userText = input.nextLine();
        String normText = normalizeText(userText);

        System.out.println("Enter a shift.");
        String strUserShift = input.nextLine();
        int userShift = Integer.parseInt(strUserShift);
        String shiftText = shiftAlphabet(userShift, normText);
        System.out.println("Shifted Text: " + shiftText);

        System.out.println("Enter a grouping number.");
        String strUserGroupNum = input.nextLine();
        int userGroupNum = Integer.parseInt(strUserGroupNum);
        String encryptedText = groupify(shiftText, userGroupNum);
        System.out.print(encryptedText);

    }

    private static String normalizeText(String preText) {
        StringBuilder newText = new StringBuilder();
        for(int charNum = 0; charNum < preText.length(); charNum++) {
            char charText = preText.charAt(charNum);
            if (charText == '.' || charText == ',' || charText == ':' || charText == ';' || charText == '\'' || charText == '\\' || charText == '"' || charText == '!' || charText == '?' || charText == '(' || charText == ')') {
                newText.append("");
            } else {
                String stringText = "" + charText;
                stringText = stringText.toUpperCase();
                newText.append(stringText);
            }
        }
        return(newText.toString());
    }

    private static String shiftAlphabet(int shift, String normText) {
        StringBuilder shiftedText = new StringBuilder();
        String alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase();
        for (int index = 0; index < normText.length(); index++) {
            char currentChar = normText.charAt(index);
            int currentCharNum = alphabet.indexOf(currentChar);

            int newCharNum = currentCharNum + shift;

            while (newCharNum >= 26 || newCharNum < 0) {
                if (newCharNum >= 26) {
                    newCharNum -= 26;
                } else {
                    newCharNum += 26;
                }
            }

            char newChar = alphabet.charAt(newCharNum);
            shiftedText.append(newChar);
        }
        return(shiftedText.toString());
    }

    private static String groupify(String shiftText, int groupNum) {
        StringBuilder sbShiftText = new StringBuilder(shiftText);
        StringBuilder sbGroupText = new StringBuilder();
        String finalText = "";
        String temp = "";
        int remainder = sbShiftText.length() % groupNum; 
        while (remainder>0) {
            sbShiftText.append("x");
            remainder--;
        }
        int grouping = 0;
        System.out.println(sbShiftText);
        System.out.println(groupNum);
        for (int i = 0; i < sbShiftText.length(); i++) {
            temp += sbShiftText.charAt(i);
            grouping++;
            if (groupNum == grouping) {
                finalText += temp + " ";
                temp="";
                grouping=0;
            } 
        }
        return(finalText);
    }
}