public static void main(String... args) {
  try {
    double a00 = 0.13;
    double a01 = 0.13;
    ...
    double a99 = 0.13;
    double b00 = 0.13;
    double b01 = 0.13;
    ...
    double k99 = 0.13;

    main(null);
  } catch (StackOverflowError ex) {
    main(null);
  }
}