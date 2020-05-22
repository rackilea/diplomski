$("#country_id").change(function() {
   var xyz = $("option:selected").val();
   $.get("../Retrive_country?stateadd_1=none", {countryREF : xyz }, function(data){
       var states = eval(data);
       $('#state_ref').empty();
       $.each(states, function(index, state){
            $("<option></option>")
                .attr("value", state.stateId).text(state.stateName)
                .appendTo('#state_ref');
       });           
   }, 'text');
});