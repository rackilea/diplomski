public static void main(String[] args) {
    String sen = "I am fine today";
    String[] sen2 = {"how are (.*?) to day", "I am (.*?) today", "thank (.*?) for your answer"};
    for (String s : sen2) {
        if (sen.matches(s)) {
            System.out.print("Matche : ");
            System.out.println(sen);
        }else{
            System.out.println("Not Matche");
        }
    }
}