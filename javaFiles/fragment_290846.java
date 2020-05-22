function validateForm() {
    var valid = true;

    /* Select the form fields, will be project specific. */
    var $formFields = $('.dialog-selector .coral-Form-field');

    $formFields.each(function(){
        if (!$(this).checkValidity()) {
            valid = false;

            /* Break out of each loop */
            return false;
        }
    });

    return valid;
}