$.ajax ({  
    url: '<s:url action="callAction"/>',
    type: 'POST',
    dataType: 'text',
    success: function (data) {
        console.log(data);
    }
});