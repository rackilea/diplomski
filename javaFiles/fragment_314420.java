public class DictionaryItem {
    int hashCode;
    int length;
    char[] chars = new char[15];

    public DictionaryItem(String initialValue) {
        this();
        append(initialValue);
    }

    public DictionaryItem() {
        setEmpty();
    }

    public void setEmpty() {
        hashCode = 0;
        length = 0;
    }

    public void append(String s) {
        for (int i=0;i<s.length();i++) {
            chars[length++] = s.charAt(i);
            hashCode = 31*hashCode + s.charAt(i);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof DictionaryItem) {
            DictionaryItem di = (DictionaryItem)o;
            if (di.length == length) {
                int i = length-1;
                while (i >= 0) {
                    if (di.chars[i] != chars[i]) {
                        return false;
                    }
                    i--;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    @Override
    public String toString() {
        return new String(chars, 0, length);
    }
}