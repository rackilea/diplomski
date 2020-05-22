public class ArrayList<T> {
    private T list[];
    private int last;
    public ArrayList() {
        list = (T[])new Object[10];
    }
    public void add(T elem) {
        if(last < list.length)
            list[last++] = elem;
        else {
            T newList[] = (T[])new Object[list.length*2];
            System.arraycopy(list, 0, newList, 0, list.length);
            list = newList;
            list[last++] = elem;
        }
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int i = 0; i < last; i++) {
            sb.append(list[i].toString()+",");
        }
        sb.replace(sb.length()-1, sb.length(), "");
        sb.append(']');
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayList<String> stringList = new ArrayList<String>();
        stringList.add("Hello");
        stringList.add("World");
        stringList.add("Foo");
        System.out.println(stringList);
    }
}