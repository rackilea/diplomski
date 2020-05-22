public class IndexBean {
    //current code...
    public Date getDate() {
        if (currentLunch.getDate() != null) {
            return currentLunch.getDate().toDate();
        }
        return null;
    }
    public void setDate(Date date) {
        return currentLunch.setDate(new DateTime(date));
    }
}