function readFiles(){
    var files = document.getElementById("files").files;
    for (var file = 0 ; file < files.length; file++) {
        var reader = new FileReader();
        reader.onload = function(e){
            var object = new Object();
            object.content = e.target.content;
            var json_upload = "jsonObject=" + JSON.stringify(object);
            var xmlhttp = new XMLHttpRequest();   // new HttpRequest instance 
            xmlhttp.open("POST", "http://localhost:8080/readFileServlet");
            xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xmlhttp.send(json_upload);
        }
        reader.readAsBinaryString(files);
    }
}