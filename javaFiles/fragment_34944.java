@Before
public void setUp() {
  Field sessionContextField = FacadeBean.class.getDeclaredField("context");
  sessionContextField.setAccessible(true);
  sessionContextField.set(beanObject, mock(SessionContext.class));
}