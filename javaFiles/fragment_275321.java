@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status,
            WebRequest request) {
        //return your custom error 
        //you can access to field errors using
        //ex.getBindingResult().getFieldErrors()
    }


    @ExceptionHandler(value = { javax.validation.ConstraintViolationException.class })
    protected ResponseEntity<Object> handleConstraintViolation(
            javax.validation.ConstraintViolationException ex) {
        //return your custom error message
    }

    @ExceptionHandler(value = { org.hibernate.exception.ConstraintViolationException.class })
    protected ResponseEntity<Object> handleHibernateConstraintViolation(
            org.hibernate.exception.ConstraintViolationException ex) {
        //return your custom error message
    }