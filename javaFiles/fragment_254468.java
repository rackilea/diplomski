List<Int> brute(List<Int> result, List <Int> given) {
    if (given is empty) return result;
    foreach i in given
        if i can follow result
            r = brute(result + i, given - i)
            if r != null return r
    return null
}
solution = brute([], [1,2,3,4,5,6])