$.ajax({
            type: 'POST',
            url: 'http://localhost/services/getVillages/',
            data: {val1: 1, val2: 2, val3: 3}, 
            dataType: "json",
            success: function (data) {
                alert("party hard"); 
            },
            error: function (data) {
                alert("restful cagirmada hata"); 
            }
        });