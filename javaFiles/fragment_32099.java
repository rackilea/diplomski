// Create sample ArrayList. Don't do this in your actual code.
ArrayList<Integer> items = new ArrayList<Integer>() {
    {
        add(1);
        add(2);
        add(3);
        add(2);
        add(3);
        add(2);                
        add(4);                
    }
};

int step = 24;
Set<ArrayList<Integer>> result = new HashSet<>();       

for (int i = 0; i < items.size(); i++) {
    Integer item1 = items.get(i);
    ArrayList<Integer> currentArray = new ArrayList<>();
    for (int j = 0; j < items.size(); j++) {
        Integer item2 = items.get(j);
        if (item1 == item2) { // This is where you need to find the difference of dates
            currentArray.add(item1);
        }
    }
    result.add(currentArray);
}

System.out.println(result);