@Override
public String toString() {
    // Return only title from this method to print title into list row.
    StringBuilder sb = new StringBuilder();
    sb.append("TITLE=" + getTitle() + "\n");
    return sb.toString();
    // OR
    // return getTitle(); // Better is to return this.title;
}