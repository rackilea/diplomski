$( "#idDateField" ).change(function() {
         var dateval = $( "#idDateField" ).val();
         var sendData = {dateval: dateval}
         $.ajax({
                 url :"activeSlots?date=" + dateval ,
                success: function (data) {
                    alert(data);
                    $('#idTimefield').empty();
                    var times=JSON.parse(data);
                    var values= Object.values(times);
                    var keys = Object.keys(times);


                    for(i=0 ; i<values.length;i++){
                        $('#idTimefield').append('<option value="' + keys[i] + '">' + values[i] + '</option>');
                    }


                        },
                        error:function(data) {
                            alert("error:"+data.val);
                        }               
            });
        });     
});