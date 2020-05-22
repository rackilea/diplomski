@Override
public Map<String, Object> my() {
    List<Integer> test = new ArrayList<>();
    for (int hour=0; hour<23; hour++) {
        if (var.contains(hour)){       
            test.add(1);
        }
        else {
            test.add(0);
        }

    }  
}