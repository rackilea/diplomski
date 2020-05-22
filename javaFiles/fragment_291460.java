public boolean isLaterDay(Date date, Date reference) {
    if (date.getYear () > reference.getYear ()) return true;
    if (date.getYear () < reference.getYear ()) return false;
    if (date.getMonth() > reference.getMonth()) return true;
    if (date.getMonth() < reference.getMonth()) return false;
    return (date.getDate() > reference.getDate());
}