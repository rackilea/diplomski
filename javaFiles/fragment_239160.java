public static boolean findWithAnotherLastName(TreeSet<Trainee> trs, Trainee someone) {
    Trainee lower = trs.lower(someone);
    Trainee higher = trs.higher(someone);
    if (lower != null && lower.getFirstName().equals(someone.getFirstName())) {
        return true;
    }
    return higher != null && higher.getFirstName().equals(someone.getFirstName());
}