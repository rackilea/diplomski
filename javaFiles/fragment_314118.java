public int getIndexForName(String name) {
    if (stadiumNames.contains(name)) {
        int total = 0;
        for (int i = 0 ; i < stadiumNames.size() ; i++)
            if (stadiumNames.get(i).equals(name))
                total += gameRevenue.get(i);
        System.out.println("The total revenue is: " + total);
        System.exit(0);
    }
    return -1;
}