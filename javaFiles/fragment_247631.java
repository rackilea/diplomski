class Dog implements Comparable<Dog>{
    //somecode

    @Override
    public int compareTo(Dog o) {
        return birthday.compareTo(o.birthday);
    }
}