while(iterator.hasNext()){
    String str = iterator.next();

    if(str.equals('test')){
        iterator.remove();
    }
}