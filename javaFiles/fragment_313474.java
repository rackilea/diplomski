for (ListIterator<String> iter=swapIndex.listIterator(); iter.hasNext() ; ) {
    String current = iter.next();
    if(current.equals("Znk")){
        swapIndextemp.add(string);
        iter.remove();
    }
}