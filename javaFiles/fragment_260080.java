while (true) {
    middle = (left + right) / 2;
    int copmarison = Name.compareTo(StudentName[middle]);
    if (Name.equals(StudentName[middle])) {
        return middle;
    } else if (left > right) {
        return count;
    } else {
        if (copmarison > 0) {
            left = middle + 1;
        } else {
            right = middle - 1;
        }
    }
}