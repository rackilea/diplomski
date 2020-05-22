String dummy_method(List<Response> myList){
    final boolean anyMatch = myList.stream()
        .map(Response::getYesOrNoValue)
        .map(value -> value == null ? "NO" : value) // since we compare to "NO", we have to convert nulls
        .anyMatch("NO"::equals); // changed from "YES" to "NO"

    return anyMatch ? "NO" : "YES"; // flipped "YES" and "NO"
}