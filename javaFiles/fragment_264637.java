for (String addObject : removingLetterCharacters) {
    if(!addObject.isEmpty()) {
        convertValue = Integer.parseInt(addObject);
        splitInteger.add(convertValue);
    }
}

for (String addObject : removingNumberCharacters) {
    if(!addObject.isEmpty()) {
        splitString.add(addObject);
    }
}