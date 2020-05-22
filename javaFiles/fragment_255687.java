Scanner cin = new Scanner(System.in);

String word;
do {
    word = cin.next();
    System.out.println(word);
} while (!word.equals("q"));