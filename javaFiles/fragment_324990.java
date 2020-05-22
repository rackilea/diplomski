public void ensure_helper_is_used_to_invoke_a_RequestObject() {
  // given a service that has an helper collaborator
  ... other fixture if necessary

  // when
  myService.behaviorToTest();

  // then
  verify(someHelperMock).invokeMeth(isA(RequestObject.class));
}