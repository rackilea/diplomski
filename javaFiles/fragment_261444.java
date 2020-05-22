Collections.sort(SomeClassList, new Comparator<T>() { 
\\ T is a type parameter, you need to pass type argument here

@Override
public int compare(T lhs, T rhs) {
        return lhs.compareTo(rhs);
    }
});