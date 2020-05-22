item.sort((lineItem1, lineItem2) -> {
    if (lineItem1.equals(lineItem2)) {
        return 0;
    } else if (!lineItem1) {
        return 1; 
    } else {
        return -1;
    }
});