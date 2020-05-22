/**
 * @param args
 */

public static void main(String[] args) {
    // TODO Auto-generated method stub
    String str = "a11b4c5";
    System.out.println(getAnswerByPassingString(str));

}

public static String getAnswerByPassingString(String str) {
    String number = "";
    String letter = "";
    String resStr = "";
    ArrayList<String> stringList = new ArrayList<String>();
    ArrayList<String> numbersList = new ArrayList<String>();

    for (int i = 0; i < str.length(); i++) {
        char a = str.charAt(i);
        if (Character.isDigit(a)) {
            number = number + a;
            //numbersList.add("" + a);
        } else {
            letter = letter + a;
            stringList.add("" + a);
        }
    }

    Matcher m = Pattern.compile("\\d+").matcher(str);
      //List<Integer> numbers = new ArrayList<Integer>();
      while(m.find()) {
        numbersList.add(""+Integer.parseInt(m.group()));
      }
     // System.out.println(numbers);

    for (int i = 0; i < stringList.size(); i++) {

        int j = Integer.parseInt(numbersList.get(i));
        String concatStr = stringList.get(i);

        int count = 0;
        for (int k = 1; k <= j; k++) {
            concatStr = concatStr + concatStr;
            if (k == j)
                count = k;
        }
        resStr = resStr + concatStr.substring(0, count);

        concatStr = "";

    }

    return resStr;
}