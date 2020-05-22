@Test
  @SuppressWarnings("unchecked")
  void TestDoSomething(){
    SubClass sb = mock(SubClass.class);

    Example ex = new Example(sb);

    ArgumentCaptor<Map<String, CompoundClass>> argCaptor = ArgumentCaptor.forClass(Map.class);

    ex.doSomeThing();

    verify(sb).doSomeThingSubClass(argCaptor.capture());

    System.out.println(argCaptor.getValue().get("x").a);
  }