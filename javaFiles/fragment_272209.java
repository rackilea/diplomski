public interface FormSubmission {
  void set();
  default submitForm() {
    open();
    set();
    submit();
  }
}