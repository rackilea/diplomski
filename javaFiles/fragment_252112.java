$('#inputid, #inputid').bind('keypress', function (event) {
    var regex = new RegExp(/^[a-zA-Z ]+$/); //Note i left a white space between brackets.
    var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
            if (!regex.test(key)) {
               event.preventDefault();
               return true;
            }
    });