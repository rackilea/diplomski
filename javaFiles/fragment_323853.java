function showDialog(baseContext) {
    var article = $('#articleId').val().replace(/\s+/g, "");

    var data = {
            "article": $('#articleId').val().replace(/\s+/g, ""),
            // other keys and values
            "lastKey": $('#lastValueId').val().replace(/\s+/g, "")
    }

    $.ajax({
        type : "POST",
        url : "${pageContext.request.contextPath}/sync/getFilter",
        data: data,
        success : function(data) {
            onClickTable();
        }
    });
}