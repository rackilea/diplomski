public static void main(String[] args) {
    String morseA;
    morseA = "•-";
    String morseB;
    morseB = "-•••";
    String morseC;
    morseC = "-•-•";
    String morseD;
    morseD = "-••";
    String morseE;
    morseE = "•";
    String morseF;
    morseF = "••-•";
    String morseG;
    morseG = "--•";
    String morseH;
    morseH = "••••";
    String morseI;
    morseI = "••";
    String morseJ;
    morseJ = "•---";
    String morseK;
    morseK = "-•-";
    String morseL;
    morseL = "•-••";
    String morseM;
    morseM = "--";
    String morseN;
    morseN = "-•";
    String morseO;
    morseO = "---";
    String morseP;
    morseP = "•--•";
    String morseQ;
    morseQ = "--•-";
    String morseR;
    morseR = "•-•";
    String morseS;
    morseS = "•••";
    String morseT;
    morseT = "-";
    String morseU;
    morseU = "••-";
    String morseV;
    morseV = "•••-";
    String morseW;
    morseW = "•--";
    String morseX;
    morseX = "-••-";
    String morseY;
    morseY = "-•--";
    String morseZ;
    morseZ = "--••";

    Scanner morseInput = new Scanner(System.in);
    System.out.println("type a letter and it will be converted into morse code!");

    String morseTranslation = morseInput.nextLine();

    if (morseTranslation.length() > 0) {
        for (int i = 0; i < morseTranslation.length(); i++) {
            String character = ""+morseTranslation.charAt(i);
            if (character.contains("a")) {
                System.out.println(morseA);
            }
            if (character.contains("b")) {
                System.out.println(morseB);
            }
            if (character.contains("c")) {
                System.out.println(morseC);
            }
            if (character.contains("d")) {
                System.out.println(morseD);
            }
            if (character.contains("e")) {
                System.out.println(morseE);
            }
            if (character.contains("f")) {
                System.out.println(morseF);
            }
            if (character.contains("g")) {
                System.out.println(morseG);
            }
            if (character.contains("h")) {
                System.out.println(morseH);
            }
            if (character.contains("i")) {
                System.out.println(morseI);
            }
            if (character.contains("j")) {
                System.out.println(morseJ);
            }
            if (character.contains("k")) {
                System.out.println(morseK);
            }
            if (character.contains("l")) {
                System.out.println(morseL);
            }
            if (character.contains("m")) {
                System.out.println(morseM);
            }
            if (character.contains("n")) {
                System.out.println(morseN);
            }
            if (character.contains("o")) {
                System.out.println(morseO);
            }
            if (character.contains("p")) {
                System.out.println(morseP);
            }
            if (character.contains("q")) {
                System.out.println(morseQ);
            }
            if (character.contains("r")) {
                System.out.println(morseR);
            }
            if (character.contains("s")) {
                System.out.println(morseS);
            }
            if (character.contains("t")) {
                System.out.println(morseT);
            }
            if (character.contains("u")) {
                System.out.println(morseU);
            }
            if (character.contains("v")) {
                System.out.println(morseV);
            }
            if (character.contains("w")) {
                System.out.println(morseW);
            }
            if (character.contains("x")) {
                System.out.println(morseX);
            }
            if (character.contains("y")) {
                System.out.println(morseY);
            }
            if (character.contains("z")) {
                System.out.println(morseZ);
            }
        }
        System.out.println(morseTranslation.charAt(0) + " " + morseTranslation.charAt(1));
    }

}