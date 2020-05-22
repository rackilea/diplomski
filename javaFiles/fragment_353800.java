try {
} catch (Exception e) {
  if (e instanceof SubclassOfException) {
    // Do something specific to SubclassOfException.
    // Note that you have to cast explicitly if you want to use
    // subclass-specific properties of SubclassOfException.
  } else {
    // Do something for other types.
  }
}