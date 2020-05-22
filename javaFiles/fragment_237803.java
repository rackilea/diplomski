public String change(String characterString) {

    for (Change change : changes) {
        characterString = change.change(characterString);
    }

    return characterString;
}