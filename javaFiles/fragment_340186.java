function ValidatePhone() {
    var phoneRegExp = 
        /^((\+)?[1-9]{1,2})?([-\s\.])?((\(\d{1,4}\))|\d{1,4})(([-\s\.])?[0-9]{1,12}){1,2}$/;
    var phoneVal = $("#txtPhone").val();
    var numbers = phoneVal.split("").length;
    if (10 <= numbers && numbers <= 20 && phoneRegExp.test(phoneVal)) {
        alert("SUCCESS");
    }
}