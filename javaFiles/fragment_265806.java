isSuperAnagram(String first, String second) {
    sb = StringBuilder(second)
    for all chars in first {
        k = search index of current char of first in sb
        if(k == -1) // char is not in sb
            return false
        else
            remove char at index k from sb
    }
    return true
}