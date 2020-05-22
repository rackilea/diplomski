@Override
public boolean equals(Object other) {
    if (other == null) return false;
    if (other.getClass() != this.getClass()) return false;
    final EnglishWord ow = (EnglishWord) other;
    return ow.word.equals(this.word);
}