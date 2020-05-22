for(j=0; j < queries.length; j++){
    int count = 0;
    for(i=0; i < strings.length; i++) {
        if (queries[j].compareTo(strings[i] == 0)) {
            count++;
        }
    }
    System.out.orintln(count);
}