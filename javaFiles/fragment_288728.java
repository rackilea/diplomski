TextFields.bindAutoCompletion(textFieldSearch, t -> {
    return list.stream().filter(elem -> 
    {
        return elem.toLowerCase().startsWith(t.getUserText().toLowerCase());
    }).collect(Collectors.toList());
});