test() {
    Instance retrieve = mock()
    when retrieve(specific something).thenReturn(specificRetrievedVal)

    test doSomething()
 }