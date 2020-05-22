<form name="myForm" id="myForm">
    <input type="button" value="Edit booking" id="smartButton" onclick="doSomethingSmart();">
</form>
<script>
    var smartButton = document.getElementById("smartButton");
    var myForm = document.getElementById("myForm");
    function doSomethingSmart() {
        if(smartButton.value == "Edit booking") { // we gonna edit booking
            document.getElementById("bookingDate").disabled = false;
            document.getElementById("returnDate").disabled = false;
            smartButton.value = "submit"; // let it in disguise as submit button
        }
        else { // we gonna submit
            if( isUserInputValied() ) {
                myForm.submit(); // submiiiiiiiiiiiiiiiiiit !

                // restore everything as if nothing happened
                document.getElementById("bookingDate").disabled = true;
                document.getElementById("returnDate").disabled = true;
                smartButton.value="Edit Booking";
            }
            else {
                alert("please fill your form correctly!");
            }
        }
    }
    function isUserInputValid() {
        // check whether the user input is valid
    }
</script>