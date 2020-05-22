Parse.Cloud.beforeSave("Point", function(request, response) {
    if (!(request.object.existed())) {
        var query = new Parse.Query("Point");
        query.addDescending("uniqueIdentifier");
        query.first({
            success: function(result) {             
                var maxId = result.get("uniqueIdentifier");             
                request.object.set("uniqueIdentifier", maxId + 1);                  
            },
            error: function() {                     
            }
        });            
    }
    response.success();
});