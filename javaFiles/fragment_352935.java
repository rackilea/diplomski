success : function(jsonResponse) {
   var arr = jsonResponse.name,  // <-----the array ["a", "b", "c"]
       opts = '<option value="0">Please select...</option>'; // <---default option
   $.each(arr, function(key, val){
      opts += '<option value="' + val + '">' + val + '</option>'; //<----generate options
   });
   $('#targetSelectElement').empty().append(opts); //<-----put the options in select element.
}