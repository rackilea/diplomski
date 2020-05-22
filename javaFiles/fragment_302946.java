$('#updateTask').submit(function(event) {

event.preventDefault();
// this is the current reference of form on which you are performing action.
var id = $(this).find("#id").attr("value");
var name = $(this).find("#name").prop("value");
var description = $(this).find("#description").prop("value");

//Make the ajax call
$.ajax({
    url : requestMapping,
    type : "POST",
    data : {
        "id" : id,
        "name" : newName,
        "description" : newDescription
    },

    //handle success
    success : function(response) {
        alert("Task " + id + " has been updated!");
    },

    //handle errors
    error : function(xhr, status, error) {
        alert(xhr.responseText);
    }});
    return false;
});