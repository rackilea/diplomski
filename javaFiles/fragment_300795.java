function addData(){
  if(window.XMLHttpRequest) { //Assuming you're not on one of the old IEs.
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange=function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            var myArr = JSON.parse(xhttp.responseText);
            //console.log(myArr);
            addToTable(myArr); // function to add data to table.

        }
    }
    xhttp.open("POST","login.do",true);
    var formData = new FormData(document.getElementById('loginForm'));
    xhttp.send(formData);
  }
  else console.log('not working');
}