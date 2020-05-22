// Assign the Point a unique identifier on creation
Parse.Cloud.afterSave("Point", function(request) {

    // Check if the Point is new
    if (!(request.object.existed())) {

        // Get the unique identifier
        var uniqueIdentifier = ...

        // Set the unique identifier
        request.object.set('uniqueIdentifier', uniqueIdentifier);
    }
});