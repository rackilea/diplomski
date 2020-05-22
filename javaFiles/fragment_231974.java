@Override
public int compareTo(Word o) {
    String thisStr= this.word.toLower();
    String oStr=o.word.toLower();
    return thisStr.compareTo(oStr);
}