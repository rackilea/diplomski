protected CustomException convertValidionErrorToAppException( MethodArgumentNotValidException oMethodArgNotvalidExp ) {

    CustomException Exp = null;

    BindingResult oBindingResult = oMethodArgNotvalidExp.getBindingResult();
    // Get the first error associated with a field, if any.\
    if ( oBindingResult.hasFieldErrors() ) {
        Exp = processFieldError( oBindingResult, oMethodArgNotvalidExp );

    } else {
        Exp = processErrors( oBindingResult, oMethodArgNotvalidExp );
    }

    return Exp;
}