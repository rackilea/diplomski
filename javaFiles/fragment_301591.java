// An object of this type can be compared to an Object
class X implements Comparable<Object> {

    @Override
    public int compareTo(Object o) {
        ...
    }


}

X x = new X();
mymethod(x);