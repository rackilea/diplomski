SuperClass[] subClasses = new SubClass[] { new SubClass("1"), new SubClass("2") };

    SuperClass[] subClassesCopy = Arrays.stream(subClasses)
        .map(orig -> orig.deepCopy())
        .collect(Collectors.toList())
        .toArray(new SuperClass[subClasses.length]);