private static boolean getAnswer() {
  while (true) {
    String answerStr = readLine ("would you like instructions? ");
    answerStr = (answerStr != null) ? answerStr.trim() : "";
    if ("yes".equalsIgnoreCase(answerStr)) {
      return true;
    } else if ("no".equalsIgnorecase(answerStr)) {
      return false;
    } else {
      System.out.println("Wrong answer");
    }
  }
  return false;
}