$.ajax({
  async:settings.Async,url:Url,cache:false,type:'POST',data:$("#tags").val()
 }).done(function (result) {
     $( "#tags" ).autocomplete({                         
        source: result
     });
 });