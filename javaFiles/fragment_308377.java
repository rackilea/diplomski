...
var map = {}; // using object instead of map 
$("#mapBody tr").map(function () {
     var value = $(this).find( "input[name=value]").val();
     var index = $(this).find("input[name=index]").val();
     map[index] = value; // setting property of object
});
...
var data = {
//other values
"map": map, // using map object instead of array
//Some more values
}
...
$.ajax({
   url: "/mapping",
   type: "POST",
   data: JSON.stringify(data),
   ...
});