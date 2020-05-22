$.ajax({
        type: 'GET',
        url: '<Your URL>',
        cache: false,
        dataType: 'json',
                    // Your input parameters go here
        data: {name: 'someValue'},
        success: function(data, textStatus){                                
        },
        error: function(xhr, textStatus, errorThrown){
        }
    });