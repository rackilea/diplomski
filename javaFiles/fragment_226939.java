do {
    System.out.print("Word: ");
    word = input.next();
    if( "quit".equalsIgnoreCase(word) )
        break;
    System.out.println(pigLatinWord(word));
    System.out.println();
} while (true);