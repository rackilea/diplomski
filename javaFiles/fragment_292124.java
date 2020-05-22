class SecondDep {
  interface Factory {
    SecondDep create(FirstDep first);
  }

  @Inject public SecondDep(@Assisted FirstDep first) { /**/ }
}