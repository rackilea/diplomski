function searchViaAjax(id) {
var tempId = id;
$.ajax({
    type : "POST",
    url : "/search/api/getSearchResult",
    data : {id:tempId},
    timeout : 100000,
    success : function(id) {
        console.log("SUCCESS: ", id);
        display(id);
        alert(response);   
    },
    error : function(e) {
        console.log("ERROR: ", e);
        display(e);
    },
    done : function(e) {
        console.log("DONE");
    }
});
}