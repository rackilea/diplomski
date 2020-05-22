public static void main(String[] args) {
    List<String> firstList  = new ArrayList<>(Arrays.asList("king", "king", "queen", "jack", "queen"));
    List<String> secondList = new ArrayList<>(Arrays.asList("one", "one", "one", "two", "one"));

    List<String> cards = new ArrayList<>();
    List<String> positions = new ArrayList<>();
    for(int i = 0; i< firstList.size(); i++){
        String temp = firstList.get(i);
        if(!cards.contains(temp)){
            cards.add(temp); 
            positions.add(secondList.get(i)); 
        }
    }
    System.out.println(cards);
    System.out.println(positions);
}