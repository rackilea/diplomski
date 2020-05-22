function loadPage(elementId, typeId) {
    $.ajax({
        url: "loadPage/" + typeId, 
        type: "GET", 
        dataType: "html", 
        success: function (data) { 
            alert(data);
            if(data.indexOf("loginpageflag") > -1) { 
                window.location.replace("/login"); 
            } 
            var selection = $("#" + elementId); 
            selection.empty(); 
            selection.append(data); 
        }
    });
}