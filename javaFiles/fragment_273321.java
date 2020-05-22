window.onbeforeunload = function () {

var confirmation = confirm("Are you Sur want to logout the session ?");
if (confirmation == true)
  {
    if((sessionId != null)&&(sessionId!="null")&& (sessionId != ""))
        logout();
 // confirmation = "You pressed OK!";
  }
else
  {
 // confirmation = "You pressed Cancel!";


  }