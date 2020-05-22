function validateFormAndSubmit() {
    if (!isEmptyField()) {
        dataString = $("#form").serialize();
        dataString = "name=" + $("#name").val();

        $.ajax({
            type: "POST",
            url: "FormCheck",
            data: dataString,
            dataType: "json",

            success: function(data) {
                if (data.success) {
                    //alert(data.value.name);
                    if (data.value.name === $('#name').val()) {
                        alert("name existed");
                        return true;
                    }
                    $('#form').submit();
                }
                return false;
            }
        });
    }
 }

 function isEmptyField() {
     if (!$("#name").val().length) {
         alert("name Field is required");
         return true;
     }
     return false;
 }