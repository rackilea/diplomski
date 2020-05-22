// Now that we know the size of the list, we can define the array size
    Object[][] retObj = new Object[list1.size()][2];
    for (int i = 0; i < list1.size(); i++) {
        retObj[i][1] = list1.get(i);
    }

    return retObj;