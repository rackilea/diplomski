public UnoCard getMatch(UnoCard searchCard) {
    return getMatch(searchCard, 0);
}

private UnoCard getMatch(UnoCard searchCard, int counter) {
    //int counter = 0
    ... the rest of your code

    // Recursion at the end
    getMatch(searchCard, counter);
}