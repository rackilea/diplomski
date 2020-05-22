function retraso(){
    var x = document.getElementById("reporte");
    var content = x.innerHTML;
    var vars = getUrlVars();
    var location = document.getElementById("url").value;
    var url = location+"?"+vars ;
    xmlhttp = GetXmlHttpObject();
    if (!xmlhttp) {
        alert ("Browser does not support HTTP Request");
        return;
    }
    var xml = xmlhttp;
    xmlhttp.onreadystatechange = function () {
        if (xml.readyState == 4) {
            x.innerHTML = xml.responseText;
        } else {
            x.innerHTML = content;
        }     
    };
    xmlhttp.open("GET",url,true);
    xmlhttp.send(null);

    return true;
}