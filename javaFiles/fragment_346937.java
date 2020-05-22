BASE_URL = "http://server_url/" // Your REST interface URL goes here

$(".postcode-input button").click(function () {
    var postcode = $(this).parents(".postcode-input")
        .children("input").val();
    // First do some basic validation of the postcode like
    // correct format etc.
    if (!validatePostcode(postcode)) {
        alert("Invalid Postal Code, please try again");
        return false;
    }
    var finalUrl = BASE_URL += "?postcode=" + postcode; 
    $.ajax({
        url: finalUrl,
        cache: false,
        success: function (html) {
            // Parse the recieved data here.
            console.log(html);
        }
    });
});