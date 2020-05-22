func printAllWords() {
    var word = [0, 0]
    for _ in 0 ..< pow(alphabet.count, word.count) {
        if word.contains(requiredChar) { print(word) }
        for char in 0 ..< word.count {
            word[char] = (word[char] + 1) % alphabet.count
            if word[char] != 0 { break } // overflow
        }
    }
}