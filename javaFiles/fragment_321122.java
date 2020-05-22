$("#menuUrl").submit(function(){
    var obj = $(this).serializeObject();
    obj.parentId = getParentId(menuDivId);

    $.ajax({
        url: config.resourcePath+"/addUrl.html", 
        data : JSON.stringify(obj),
        contentType : 'application/json',
        type : 'POST',
        context: document.body,
    }).done(function(response) {
        $("#site").append(response);
    });

    return false;
});