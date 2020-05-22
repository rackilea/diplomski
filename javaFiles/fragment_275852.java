function search(start, end, searchItem) {

    var xCnt = 0;

    for (var start = 0; start <= end; start++) {

        if ((start + '').indexOf(searchItem + '') >= 0) {
            xCnt += 1;
        }

    }
    return xCnt;
}