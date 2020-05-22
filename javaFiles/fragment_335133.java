for (int i = 0; i < items.size(); i++) {
    if (testWeight + items.get(i).getWeight() <= 8000) {
        testWeight += items.get(i).getWeight();
    } else {
        u1Rockets.add(new U1(120, 10000, 18000, testWeight));
        testWeight = 0;
        // re-check the skipped item
        i--;
    }
}

// add the last rocket
u1Rockets.add(new U1(120, 10000, 18000, testWeight));