public static void printElement(){
//            ^--- No `synchronized ` here unless you REALLY need it for other reasons

    synchronized (list) {
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            //print element
        }
    }
}