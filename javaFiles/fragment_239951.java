@Override
public int compareTo(Person person) {
    int len1 = name.length();
    int len2 = person.name.length();

    if(len1 > len2) {
        return 1;
    }
    else if(len1 < len2) {
        return -1;
    }
    else {
        return name.compareTo(person.name);
    }
}