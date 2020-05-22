if (grade.equals("A")) {
    return a;
} else if (grade.equals("B")) {
    return b;
} else if (grade.equals("C")) {
    return c;
} else if (grade.equals("D")) {
    return d;
} else if (grade.equals("F")) {
    return f;
}
throw new IllegalArgumentException("The value you entered is not valid");