public static boolean checkStartAndEndTimeTag(List<Tag> tags) {
    boolean isSuccess = false;
    int starts = 0;
    int ends = 0;
    for (Tag tag : tags) {
        if (tag.getKey().equals("start")) {
            starts = 1;
        } else if (tag.getKey().equals("end")) {
            ends = 1;
        }
    }
    isSuccess = (starts + ends) == 2;
    return isSuccess;
}