public boolean isPalindrome (Stack a, Stack b) {
    if (a.size() != b.size()) {
        return false;
    }

    while (a.size() > 0) {

        if (!a.pop().equals(b.pop())) {
            return false;
        }

    }
    return true;

}