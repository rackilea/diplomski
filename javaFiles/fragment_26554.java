$.ajax({
    cache : false,
    type : "GET",
    dataType : "json",
    url : "UserServlet?id=" + userId,
    success : function(result) {
        alert(result.profileUser);
    }
});