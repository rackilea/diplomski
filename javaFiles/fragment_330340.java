@Override
public int compareTo(@NonNull Person another) {
    if (age == another.age) {
        return name.compareToIgnoreCase(another.name);
    } else if (age < another.age) {
        return -1;
    } else {
        return 1;
    }
}