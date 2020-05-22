public class MyOwnString {

    private char data[];
    public static void main(String[] args) {
        String a = "Welcome to this world";
        char[] input = a.toCharArray();
        MyOwnString quote = new MyOwnString(input);

        System.out.println("The string is : \"" + a + "\"");
        System.out.println("\n--------------------------------\n");

        System.out.println("To invert the string : " + quote.changeCase());
        System.out.println("\n--------------------------------");
    }

    public MyOwnString(char[] data){
        this.data = data;
    }

    public String changeCase(){
        int gap = 'A' - 'a';
        for(int i = 0; i < this.data.length; i++){
            char a = this.data[i];  
            if (a >= 'a' && a <= 'z') {
                this.data[i] = (char)(a + gap);
            } else if (a >= 'A' && a <= 'Z') {
                this.data[i] = (char)(a - gap);
            }
        }
        return new String(this.data);

    }
}