@Test
fun `must show toast message when onValidationSucceeded is called and signature is Operator`() {
    // Given
    signatureSigned("unusedName", "unusedSig", null, SignatureType.OPERATOR) 
`when`(app.getString(R.string.quality_control_signatures_not_complete)).thenReturn("Operator and Engineer signature required")
    // When
    presenter.onValidationSucceeded()
    // Then
    verify(view).showToastMessage("Operator and Engineer signature required")
}