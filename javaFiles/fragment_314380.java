abstract class MobileVerificationDetails {

  @EmbeddedId
  private MobileVerificationKey id;

  @PrePersist
  void initIdentifier() {

    if (id == null) {
      this.id = … // Create ID instance here.
    }
  }
}