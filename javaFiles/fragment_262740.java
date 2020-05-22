private volatile List publicList;

// Thread A
List originalList = ...;
while (true) {
    modifyList(originalList); // Modify list
    publicList = new ArrayList(originalList); // Pusblish a copy
}

// Thread B
while (true) {
    for (Object o: publicList) { // Iterate over a published copy
        ...
    }
}