"yyyList": [
    {
      "Id": "1",
      "Name": "aaaa "
    }, {
      "Id": "2",
      "Name": "bbb "
    }, {
      "Id": "6",
      "Name": "ccc "
    }, {
      "Id": "7",
      "Name": "ddd "
    } ]


$.ajax({
              url: "URL",
               //data: "",
               type: "GET",
               dataType: 'json',
               success: function (data) {            
               $.each(data.YYYList, function () {
                  $('#state').append('<'option value='+this.Id+'>'+this.Name+'<'option>');
               });
            }
        })