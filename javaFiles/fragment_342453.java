@Test
public void testPutThrowsIllegalStateException() {
    assertThatIllegalArgumentException().isThrownBy(() -> llmm.put("A", null));
    assertThatIllegalArgumentException().isThrownBy(() -> llmm.put(null, 1));
    assertThatIllegalArgumentException().isThrownBy(() -> llmm.put(null, null));
}