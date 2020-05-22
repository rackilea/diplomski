boolean allOK = accept.stream().allMatch(s ->
    s.length() == 7 || s.length() == 9 || s.length() == 11);

if (!allOK) {
    // display error message
}