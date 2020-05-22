public int compareTo(LetterCount other) {
    if ( count < other.count )
       return -1;
    else if (count == other.count)
       return 0;
    else
       return 1;
}