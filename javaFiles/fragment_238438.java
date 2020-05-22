List<String> messageCodes = this.getEmailValidationCode( eSignatureInTO );

if( messageCodes.contains( "ES01" ) ) {
    IESignatureIntegrationOutDto eSignatureOutTO = getEsignService().resendDocuments( eSignatureInTO );
    eSignatureInTO.setResendDocs( eSignatureOutTO.isResendDocs() );
} else if( messageCodes.contains( "EE01" ) ) {
    emailValidationMessage = UiIntegrationKeyConstants.EMAIL_FORMAT_ERROR_MESSAGE;
} else if( !Collections.disjoint(messageCodes,Arrays.asList( "ES02", "ES03", "ES04", "EE02", "EE03", "EE04" ) ) ) {
    emailValidationMessage = UiIntegrationKeyConstants.EMAIL_VALIDATION_ERROR_MESSAGE;
} else {
    emailValidationMessage = UiIntegrationKeyConstants.EMAIL_VALIDATION_MESSAGE;
}