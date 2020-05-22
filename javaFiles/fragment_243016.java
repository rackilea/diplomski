public static void main(String[] args) {
    List <String> sentence= new ArrayList <>();
    sentence.add("this is a good dog");
    sentence.add("cats drink milk");
    sentence.add("Animals are beautiful creatures");

    List <String> keyword= new ArrayList <>();
    keyword.add("dog");
    keyword.add("cats");
    keyword.add("beautiful");
    keyword.add("good");
    keyword.add("are");
    keyword.add("this");
    keyword.add("milk");

    List<List<String>> result = new LinkedList<>();
    for(String sen: sentence){
        List<String> tempList = new ArrayList<>();
        for(String key: keyword){            
            if(sen.contains(key)){
                tempList.add(key);
            }
        }
        tempList.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                   return sen.indexOf(o1) -  sen.indexOf(o2) ;
                }
        });
        result.add(tempList);
    }
    for(List<String> r : result){
        System.out.println(r);
    }
}