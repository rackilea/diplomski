ArrayList<Entry> mEntries;
String copy;
String name1;
int i;
public String getShareData() {
    copy = "";
    for (Entry n : mEntries) {
        name1 = n.getS();
        i = boolToInt(n.isB());
        copy += name1 + "\t" + i + "\n";
    }
    return copy;
}

public int boolToInt(boolean b) {
    return b ? 1 : 0;
}