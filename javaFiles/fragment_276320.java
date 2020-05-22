public class Test01 {

    private Character[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private char[] decodedText;
    private String[] plainText;
    private java.util.List<Character> alphabetList;

    public Test01(){
        alphabetList = java.util.Arrays.asList(alphabet);
        plainText = new String[alphabet.length];
    }

    public String[] producePlaintext(String cipherText) {
        //put each letter of the ciphertext in an array of characters in the upper case format
        char[] message = cipherText.toUpperCase().toCharArray();
        //loop through all the possible keys
        for (int key = 0; key < alphabet.length; key++) {
            //set the value of the decrypted array of characters to be the same as the length of the cipher text
            decodedText = new char[message.length];
            //loop through the characters of the ciphertext
            for (int i = 0; i < message.length; i++) {

                //if character is not space
                if (message[i] != ' ') {
                    //shift the letters
                    decodedText[i] = alphabet[(alphabetList.indexOf(message[i])+key) % alphabet.length];
                }else{
                    decodedText[i] = ' ';
                }
            }
            plainText[key] = String.valueOf(decodedText);
        }
        return plainText;
    }

    public static void main(String[] args) {
        Test01 t = new Test01();
        for(String pt : t.producePlaintext("abc")) {
            System.out.println(pt);
        }
    }

}