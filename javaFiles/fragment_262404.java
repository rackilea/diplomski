// a naive implementation for demonstration purpose
class LocalDate {

    String hour;
    String minute;
    String second;

    LocalDate(String string) {
        hour = string.substring(0, 2);
        minute = string.substring(2, 4);
        second = string.substring(4, 6);
    }

    @Override
    public String toString() {
        return String.format("LocalDate{%s%s%s} - hashcode: %d", hour, minute, second, this.hashCode());
    }
}