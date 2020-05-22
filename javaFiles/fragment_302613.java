for (int i = 1; i < 35; i++) {
        list2.add(new Integer(i));
    }
    Collections.shuffle(list2);
    for (int i = 0; i < list2.size(); i++) {
        if (list2.get(i).equals(list.get(i))) {
            // Swap, exchange with another value:
            if (i > 0) {
                ... set with previous one at i-1 or 0
            } else { // For i == 0, we 
                ... set with size() -1
            }
        }
    }