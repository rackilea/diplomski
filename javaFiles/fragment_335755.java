@Mock IPopup m_popup;

@Test
public void callbackTest()
{
    String str = "test";
    ArgumentCaptor<ICallback> argument = ArgumentCaptor.forClass(ICallback.class);

    m_presenter.onClick();
    verify(m_popup).show(argument.capture());

    argument.getValue().onConfirm(str);
    assertEquals(str, m_presenter.getResult());
}