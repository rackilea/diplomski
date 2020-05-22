while(sc.hasNextLine() && sc.hasNext()){
    String word = sc.next();
    if(word.length()==4){
        words.add(word);  
    }
    System.out.println(words);
}