// initialized with MockitoAnnotations.initMocks();
@Captor ArgumentCaptor<Integer> offsetCaptor;
@Captor ArgumentCaptor<float[]> floatsCaptor;
@Mock Bar bar;

@Test
public void valuesShouldBeCloseEnough() {
  Sut sut = new Sut(bar);
  sut.doSomething();
  verify(bar).setFoo(offsetCaptor.capture(), floatsCaptor.capture());

  // check values with assertValuesAreCloseEnough, declared elsewhere
  assertValuesAreCloseEnough(offsetCaptor.getValue(), floatsCaptor.getValue());
}