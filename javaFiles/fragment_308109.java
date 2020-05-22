event.currentTarget.addEventListener("click", func, false); 
function func(event){
    var data1; 
    var str=event.currentTarget.textContent;
    var xmlhttp=new XMLHttpRequest();
    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            alert("event is" + str); 
            data1= xmlhttp.responseText;
        }
    }
    xmlhttp.open("GET","Jr6?q="+str,true);
    xmlhttp.send();
}