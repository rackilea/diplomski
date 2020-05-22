public Fizz getFizzByBuzz(Buzz buzz) {
    String apiCall = fizzApiBuilder.buildForBuzz(buzz).toString();
    return sendRequest(apiCall, jsonFizzMapper);
}

public Fizz getFizzById(Long fizzId) {
    String apiCall = fizzApiBuilder.buildForId(fizzId).toString();
    return sendRequest(apiCall, xmlFizzMapper);
}