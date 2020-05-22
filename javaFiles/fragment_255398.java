String dummy_method(List<Response> myList){
    for(Response response : myList){
        if(response != null && "NO".equals(response.getYesOrNoValue())){
            return "NO";
        }
    }
    return "YES";
}