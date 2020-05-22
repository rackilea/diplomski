TreeSet<AtomicInteger> treeSets = new TreeSet<AtomicInteger>(comparator);
        lessInteger.set(10);
        treeSets.add(middleInteger);
        treeSets.add(lessInteger);
        treeSets.add(maxInteger);
        lessInteger.addAndGet(30);
        for (Iterator<AtomicInteger> iterator = treeSets.iterator(); iterator.hasNext();) {
            AtomicInteger atomicInteger = iterator.next();
            System.out.println(atomicInteger);
        }