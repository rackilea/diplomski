public String rovarSpraket(String normalString) {

    char[] array = normalString.toCharArray(); // Input to a char array

    System.out.println("På rövarspråk:");

    String slang = "";

    for (int i = 0; i < normalString.length(); i++) {

        String add = "" + array[i];

        if(Goran.isConsonant(array[i])){

            add += "o" + array[i];

        }

        slang += add;

        }

    return slang;
}