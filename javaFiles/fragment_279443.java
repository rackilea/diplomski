public class ListBasedCollator extends Collator {

private List<String> list;

public ListBasedCollator(String[] array) {
    list = Arrays.asList(array);
}

@Override
public int compare(String source, String target) {
    if(!list.contains(target)) {
        return 1;
    }

    if(!list.contains(source)) {
        return -1;
    }

    return Integer.valueOf(list.indexOf(source)).compareTo(Integer.valueOf(list.indexOf(target)));
}

@Override
public CollationKey getCollationKey(String source) {
    return null;
}

@Override
public int hashCode() {
    return 0;
}