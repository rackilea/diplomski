public class Main {
    public static void main(String[] args) {
        String cord1 = "Name: x=23 y=60 z= 600";
        System.out.println("cord1 before:\t" + cord1);
        int c1 = cord1.length();
        char mychar = cord1.charAt(0);
        for (int a = 0; a < c1; a++){
            mychar = cord1.charAt(a);
            if (mychar == ':'){
                cord1 = cord1.substring(a+1);
                break;
            }
        }
        System.out.println("cord1 after:\t" + cord1);
    }
}