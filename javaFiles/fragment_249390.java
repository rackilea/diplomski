$(document).ready(function() {
var grpAlphaInfoVOJSON = [{"column1":"somevalue"},{"column1":"otherValues"}];
  //grpAlphaInfoVO is the arraylist returned by my controller
  $('#groupAlphaList').dataTable({
    "data": grpAlphaInfoVOJSON,
    "columns" : [
            { "data" : "column1" }
            ]
  });
});