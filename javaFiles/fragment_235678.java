while((cursor = reader.readLine()) != null){
    // compare shortest and longest.
    int currentSize = cursor.lenght;

    if (currentSize > longest.lenght || longest.equals("")) {
        longest = cursor;
    } else if (currentSize < shortest.lenght || longest.equals("")) {
        shortest = cursor;
    }

    // count lines
    lines += 1;
    content += cursor;

    // count words
    String []_words = cursor.split(" ");
    for( String w : _words)
    {
        words++;        
    }

}