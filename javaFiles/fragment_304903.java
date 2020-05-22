for (i = 0, i < strings.count, i++) {
    if (i % itemsPerColumn == 0) {
        if (i != 0) print "</div>" 
        print "<div class='container'>"
    }
    print "<div class='foo'>" + string[i] + "</div>"
}