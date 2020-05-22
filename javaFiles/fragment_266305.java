function ajaxcall(readedValue)  { 
    var xmlhttp;
    if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp=new XMLHttpRequest();
    } else {
        // code for IE6, IE5
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.onreadystatechange=function()  {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)  { 
            var returnreslut=xmlhttp.responseText;
            if(returnreslut==true){
                alert("Sucess");           
            } else  {
                alert("failed");
            }
        }
    }

    xmlhttp.open("POST","insertQueryPage.jsp",true);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send("value="+readedValue);
}