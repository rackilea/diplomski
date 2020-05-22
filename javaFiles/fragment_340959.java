for(int i = words.size()-1; i >= 0; i--) 
{
    String[] wordArr = words.get(i).split("\\s+");
    for(int j = wordArr.length - 1; j >= 0; j--) {
       System.out.println(wordArr[j]);
    }
}