List<Bar> bars = Lists.newArrayList();
    for (Base base : list) {
        if (base instanceof Bar) {
            bars.add((Bar) base);
        }
    }