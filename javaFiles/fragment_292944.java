$(function() {
  // assuming form ID="NAME"
  $(".saveLink").on("click",function(e) { 
     e.preventDefault(); // do not follow link
     $("#saveItem").val($(this).data("save")); // set the hidden field
     $("#NAME").submit();
  });
});