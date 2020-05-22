if (index == 0)
    indexArray.add(0);
else {
    while (index > 0) {
        indexArray.add(index%10);
        index=index/10;
    }
}