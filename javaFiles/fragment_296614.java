Iterator<Double> it = val.iterator();
    Double lowerBound = neginf;
    while (it.hasNext()) {
        // Get element
        Double upperBound = it.next();
        arr.add(lowerBound+" - "+upperBound);
        lowerBound = upperBound;
    }
    arr.add(lowerBound  + " - "+ posinf);