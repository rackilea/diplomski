public class SampleJava {
    public static String transformation(String line) {
        StringBuilder toReturn = new StringBuilder();
        boolean afterVowel = false;
        for(char c : line.toCharArray()) {
            char out = c;
            switch(c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                afterVowel = true;
                break;
            case 'r':
                if(afterVowel) out = 'h';
                // fall-through
            default:
                afterVowel = false;
            }
            toReturn.append(out);
        }
        return toReturn.toString();
    }
    public static void main(String[] args) throws FileNotFoundException {
        File jaws = new File("JawsScript.txt");
        Scanner input = new Scanner(jaws);
        while (input.hasNextLine()) {
            String line = input.nextLine();
            line = transformation(line);
            System.out.println(line);
        }
    }
}