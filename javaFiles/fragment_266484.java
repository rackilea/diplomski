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

    public MyOwnString changeCase(){
        int gap = 'A' - 'a';
        char[] tmpData = new char[this.data.length];
        for(int i = 0; i < this.data.length; i++){
            char a = this.data[i];  
            if (a >= 'a' && a <= 'z') {
                tmpData[i] = (char)(a + gap);
            } else if (a >= 'A' && a <= 'Z') {
                tmpData[i] = (char)(a - gap);
            } else {
                tmpData[i] = a;
            }
        }
        return new MyOwnString(tmpData);

    }

    public String toString() {
        return new String(this.data);
    }
}