public static void sortVowel(String text, String regex,Comparator comparator) {
    Scanner scanner = new Scanner(text);
    List<String> vowelWords = new ArrayList<>();

    System.out.println();
    System.out.println("Task2: ");
    while(scanner.hasNext()){
        String word = scanner.next();
        if(word.matches(regex)){
            vowelWords.add(word);
        }
    }

    Collections.sort(vowelWords, comparator);

    System.out.println();
    System.out.println();
    System.out.println("Sorted List:");
    int lineCounter = 1;
    for(String w : vowelWords){
        if(lineCounter == 12) {
            System.out.print(w + "\n");
            lineCounter = 0;
        }
        else
            System.out.print(w + " ");
        lineCounter++;
    }
  }
 }