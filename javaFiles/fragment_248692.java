//before the ajax call
$.blockUI();//or a bootstrap modal will do
$.get("/NewSearchController").then(function(response){
     //handle your response
     $.unblockUI();
}).fail(function(err){
     //handle error
     $.unblockUI();
});