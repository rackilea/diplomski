@Test
fun `must show toast message when onValidationSucceeded is called and has not been signature signed`() {
    // Given
    // We haven't signature signed (see verify)
   `when`(app.getString(R.string.quality_control_signatures_not_complete)).thenReturn("Operator and Engineer signature required")
    // When
    presenter.onValidationSucceeded()
    // Then
    verify(view).showToastMessage("Operator and Engineer signature required")
    verify(view, never()).operatorSignatureSigned()
    verify(view, never()).engineerSignatureSigned()
}