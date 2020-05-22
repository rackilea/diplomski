public int compare(Pair pr1, Pair pr2) {
    int firstResult = pr1.compareFirstElms(pr2);
    if (firstResult == 0) { //First comparison returned that both elements are equal
        return pr1.compareSecondElms(pr2);
    } else {
        return firstResult;
    }
}