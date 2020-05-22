public static LetterGrade fromDouble(double grade) {
    int len = values().length;
    for (int i = 0; i < len; i++) {
        if (grade >= values()[i].getgradePoints())
            return values()[i];
    }
    return LetterGrade.f;
}