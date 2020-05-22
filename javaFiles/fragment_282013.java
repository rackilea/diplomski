public static ArrayList<String> result(ArrayList<String>tweets, ArrayList<String> palavras){
    for (int i = 0; i <palavras.size() ; i++) {
        int count = 0;
        for (int j = 0; j <tweets.size() ; j++) {
            boolean isDone = false; //NEW
            int tweetCharIter = 1; //NEW
            while (!isDone){ //NEW
                if (tweets.get(j).substring(tweetCharIter).contains(palavras.get(i))){ //ALTERED
                    tweetCharIter += tweets.get(j).substring(tweetCharIter).indexOf(palavras.get(i)) +1; //ALTERED
                    count++;
                } else { //NEW
                    isDone = true; //NEW
                }
            }
        }
        numero.add(count);
        result.add(palavras.get(i));
    }
    return result;
}