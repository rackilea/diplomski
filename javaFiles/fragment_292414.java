@Override
public Integer convert(String word) {
    if (word == null)
        throw new IllegalArgumentException();
    return word.length();
}