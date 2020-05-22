$.ajax({
        type: 'GET',
        url: 'http://localhost:8080/api/mobile_getcountrylist',
        crossDomain: true,
        async: false,
        jsonpCallback: 'jsonpCallback',
        dataType: 'jsonp',
        contentType:'application/json',
        success: function(data) {        
         alert('ok');
        }
    });