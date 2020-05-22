while (sc.hasNext()) {
    if(sc.hasNextInt()) {
        list.add(sc.nextInt());
    } else {
        //consume data you are not interested in 
        //so Scanner could move on to next tokens
        sc.next();
    }
}