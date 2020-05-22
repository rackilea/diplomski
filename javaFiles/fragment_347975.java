function  sendImage(base64){
    var query = "number=0&id=012&base64="+encodeURIComponent(base64);
        var url = "myImage.jsp";
        xmlHttp.open("POST", url, true);
        xmlHttp.onreadystatechange = postImgAjax;
        xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xmlHttp.setRequestHeader("Content-length", query.length);
        xmlHttp.setRequestHeader("Connection", "close");
        xmlHttp.send(query);
}