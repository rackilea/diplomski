int i = 0;
    for (i=0; i<list.get(0).size(); i++) {
        try {
            Integer.parseInt(list.get(0).substring(i, i+1));
            // This is a number
            numbers.add(list.get(0).substring(i, i+1));
        } catch (NumberFormatException e) {
            // This is not a number
            letters.add(list.get(0).substring(i, i+1));
        }
    }