function process(){
     url = "text.html"
     var xhr = new XMLHttpRequest();
     xhr.open("GET", url, true);
     xhr.onreadystatechange = function() {
     if (xhr.readyState == 4){
        alert(xhr.responseText)
        }
     }

     xhr.send();
   }