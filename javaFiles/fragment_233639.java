protected CustomExceptionprocessErrors( BindingResult oBindingResult,     MethodArgumentNotValidException oMethodArgNotvalidExp ) {
    CustomException Exp = null;
    //Get all errors from Binding Errors
    ObjectError oError = oBindingResult.getAllErrors().get( 0 );
    String sCode = oError.getCode();
    if ( StringUtils.isEmpty( sCode ) || !StringUtils.isNumeric( sCode ) ) {

        Exp = new CustomException( oMethodArgNotvalidExp );

    } else {
        int iErrorCode = Integer.parseInt( sCode );
        Exp = new CustomException( iErrorCode );
    }
    return Exp;
}