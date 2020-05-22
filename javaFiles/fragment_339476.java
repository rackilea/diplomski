private final Pattern EMAIL_ADDRESSS_REGEX_PATTERN =
        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

private boolean isValidEmail(String email)
{
    return EMAIL_ADDRESSS_REGEX_PATTERN.matcher(email).find();

}