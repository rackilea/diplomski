final class Past {
  private final long differenceMs;
  public Past(final Date pastDate) {
    this.differenceMs = (System.currentTimeMillis() - pastDate.getTime());
  }
  public Date getUpdatedPastDate() {
    return new Date(System.currentTimeMillis() - differenceMs);
  }
}

class Test {
  public static void main(String[] args) throws Throwable {
    final Calendar cal = Calendar.getInstance();
    cal.set(1992, 10, 24, 0, 0, 0); // this is 24/11/1992
    final Past past = new Past(cal.getTime());
    System.out.println(past.getUpdatedPastDate());
    Thread.sleep(2000);
    System.out.println(past.getUpdatedPastDate());
  }
}