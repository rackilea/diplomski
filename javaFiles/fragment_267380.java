function addUserForm()
{
    //Collect input from html page
    var firstNameTxt = document.getElementById("firstName").value;
    var lastNameTxt = document.getElementById("lastName").value;

    var req = new REST.Request();
    req.setURI(REST.apiURL + "/rest/users");
    req.setMethod("POST");
    req.setEntity({firstName:firstNameTxt,lastName:lastNameTxt});
    req.execute(function(status, request, entity){
        document.getElementById("error").innerHTML = "<h2><span style='color:red'>" + entity + " !!</span></h2>";
    });
}