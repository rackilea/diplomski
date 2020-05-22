@Override
public int compareTo(Employee o) {
    int i = name.compareTo(o.getName());
    if (i == 0) { //ie the names are the same
        return age.compareTo(o.getAge();
    }
    return i;
}