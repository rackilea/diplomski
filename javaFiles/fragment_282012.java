public ArrayList<String> result(ArrayList<String>tweets, ArrayList<String> palavras){
     for (int i = 0; i <palavras.size() ; i++) {
        int count = 0;
         for (int j = 0; j <tweets.size() ; j++) {
        if (tweets.get(j).contains(palavras.get(i))){
            count++;
        }
    }
    numero.add(count);
    result.add(palavras.get(i));
            }
  return result;