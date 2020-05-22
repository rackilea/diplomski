function f(){
              var oRequest = new XMLHttpRequest();
var sURL = "http://"
         + "localhost:8080/sessionAlivecheck/"
         + "/example/newjsp.jsp";

oRequest.open("GET",sURL,false);
oRequest.setRequestHeader("User-Agent",navigator.userAgent);
oRequest.send(null);
//alert("hhh");
          }

          $(document).ready(function () {
  setInterval(f, 2000);
});