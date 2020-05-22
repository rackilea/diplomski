$.ajax({
    url : 'ur_servlet_url' + selValue,
    type : "POST",
    async : false,
    success : function(data) {
        //Sample data
        var data = "<select id='child'>
                    <option value='11'>Value11</option></select>"
        $("#fillValue").html(data);
    }
});