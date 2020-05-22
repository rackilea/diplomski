public class test {
    public static void main(String[] args) {
        frequencycount("cabbaa");
    }   

    static void frequencycount(String s) {
        StringBuilder output = new StringBuilder();
        Character previousCharacter = null;
        int counter = -1; 

        for (Character c : s.toCharArray()) {
            if (c.equals(previousCharacter)) {
                counter++;
            } else {
                if (previousCharacter != null) {
                    output.append(counter);
                    output.append(previousCharacter);
                }
                counter = 1;
                previousCharacter = c;
            }
        }

        if (previousCharacter != null) {
            output.append(counter);
            output.append(previousCharacter);
        }

        System.out.println("Res: " + output);
    }   
}