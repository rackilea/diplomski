$(document).ready(function(){
$("#centerForm\\:production_source").autocomplete({ source : finalData, minLength: 3,  select: function(event, ui) {
      event.preventDefault();
      var label = ui.item.label;
      var value=ui.item.value;
      var id = ui.item.id;
      $( "#centerForm\\:production_source" ).attr("value",label);
      $( "#centerForm\\:production_source_description" ).attr("value",value);
      $( "#centerForm\\:production_source_id" ).attr("value",id);
      $("#centerForm\\:renderProductionSource").click();
     } });   
});