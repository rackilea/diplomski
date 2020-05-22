public class DateComparator implements Comparator<MyFile> {

    @Override
    public int compare(MyFile f1, MyFile f2) {
        return f1.getDate().compareTo(f2.getDate());
    }
}

public class ReverseNameComparator implements Comparator<MyFile> {

    @Override
    public int compare(MyFile f1, MyFile f2) {
        return f2.getName().compareTo(f1.getName());
    }
}