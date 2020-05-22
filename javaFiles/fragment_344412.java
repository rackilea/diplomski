function autoSubmitForm(method, url, post_data) {
    var element = document.getElementById("virtual_form");
    if(element != null )
    {
        element.parentNode.removeChild(element);
    }
    var form = document.createElement("form");
    form.setAttribute("id", "virtual_form");
    form.setAttribute("style", "display:none;");
    form.method = method;
    form.action = url;   
    for(i in post_data)
    {
         var element=document.createElement("input");
         element.value=post_data[i];
         element.name=i;
         form.appendChild(element); 
    }
    document.body.appendChild(form);
    form.submit();

}

autoSubmitForm('POST','your_url.php',{id:"xyz",other_input:"input value"});