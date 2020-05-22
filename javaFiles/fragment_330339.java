@Override
public int compareTo(@NonNull Person another) {
    int result = Integer.compare(age, another.age);
    if (result == 0) {
        result = name.compareToIgnoreCase(another.name);
    }
    return result;
}