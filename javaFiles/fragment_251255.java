$.validator.addMethod("uniqueEmail", function (value, element) {
    let emailOrgName = "yourDomain/uniqueEmailCheck?emailId=" + value;
    let result = false;
    $.ajax({
        type: "GET",
        url: emailOrgName,
        dataType: "JSON",
        success: function (data) {
            if (data.data.email === 1) {
                console.log(data.data.email + ': This email exists.');
                result = false;
            } else {
                console.log(data.data.email + ': This email does not exist.');
                result = true;
            }
        },
        async: false
    });
    console.log(result);
    return result;
});

$("#form").validate({
    rules: {
        email: {
            required: true,
            email: true,
            uniqueEmail: true,
            normalizer: function (value) {
                return $.trim(value);
            }
        }
    },
    messages: {
        email: {
            required: "Please enter your email address.",
            minlength: jQuery.validator.format("Your email address must consist of at least {0} character."),
            maxlength: jQuery.validator.format("Your email address must be no longer than {0} characters."),
            uniqueEmail: "Your Email address is already registered on our system.",
        }
    },

    // Bootstrap 4 native error style.

    errorElement: "div",
    errorClass: "is-invalid",
    validClass: "is-valid",
    errorPlacement: function (error, element) {
        error.addClass("invalid-feedback");
        if (element.prop("type") === "checkbox") {
            error.insertAfter(element.next("label"));
        } else {
            error.insertAfter(element);
        }
    },
    highlight: function (element, errorClass, validClass) {
        $(element).addClass(errorClass).removeClass(validClass);
    },
    unhighlight: function (element, errorClass, validClass) {
        $(element).addClass(validClass).removeClass(errorClass);
    }
});