@Mock 
BooleanPrefField booleanPrefField;

@Test
public void testEnabled() throws Exception {
    when(prefs.enabled()).thenReturn(booleanPrefField);
    when(booleanPrefField.get()).thenReturn(false);
    assertThat(logic.isEnabled()).isEqualTo(false);
}