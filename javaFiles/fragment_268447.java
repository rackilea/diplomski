public class PassGen {

    public static void main(String[] args) {
        PassGen passGen = new PassGen();

        String generate = passGen.generate();
        System.out.println(generate);

    }
    String lAlpha = "abcdefghijklmnopqrstuvwxyz"; //used to generate lowercase pass chars
    String uAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //used to generate uppercase pass chars
    int minNum = 0; //the mininum number that a integer value can be in the password
    int maxNum = 9; //the max number "" ...........................................""
    int minString = 0;
    int maxString = 25;
    int low1 = 1;
    int high3 = 3;

    public String generate() {
        StringBuilder sb = new StringBuilder(4);

        for (int i = 0; i < 4; i++) {
            sb.append(generateCharacter());
        }
        return sb.toString();
    }

    protected char generateCharacter() {
        char result = '-';
        int ran3 = low1 + (int) (Math.random() * ((high3 - low1)));
        switch (ran3) {
            case 0:
                result = genNumber(0, 9);
                break;
            case 1:
                result = genLAlpha();
                break;
            case 2:
                result = genUAlpha();
                break;
        }

        return result;

    }

    protected char genNumber(int min, int max) {
        int randomNumber = min + (int) (Math.random() * ((max - min) + 1));
        char randomNumChar = Character.forDigit(randomNumber, 5);
        return randomNumChar;
    }

    protected char genLAlpha() {
        int randomLNum = minString + (int) (Math.random() * ((maxString - minString) + 1));
        char randomLChar = lAlpha.charAt(randomLNum);
        return randomLChar;
    }

    protected char genUAlpha() {
        int randomUNum = minString + (int) (Math.random() * ((maxString - minString) + 1));
        char randomUChar = uAlpha.charAt(randomUNum);
        return randomUChar;
    }
}