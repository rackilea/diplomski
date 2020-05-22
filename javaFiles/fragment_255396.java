String dummy_method(List<Response> myList){
    final boolean allMatch = myList.stream()
        .map(Response::getYesOrNoValue)
        .allMatch("YES"::equals);

    return allMatch ? "YES" : "NO";
}