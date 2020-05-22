public final class JpaEntityResponse {
  private String one;

  private String three;

  private String andFour;

  private JpaEntityResponse() { } // No-args constructor required by JPA spec

  public JpaEntityResponse(final String one, final String two, final String andFour) {
    this.one = one;
    this.three = three;
    this.andFour = andFour;
  }

  // ...getters
}