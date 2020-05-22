System.out.println("first loop finished");
    copyOnWriteArrayList.add(5);

    //get the new iterator after adding
    iterator = copyOnWriteArrayList.iterator();

    while (iterator.hasNext()) {
        Integer integer = (Integer) iterator.next();
        System.out.println(integer);//why not printing 5
    }