$.ajax({
        url: url + "?agent=" + JSON.stringify(agent),
        type: "GET",
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");
        },
        success: function(data) {
            alert("success");
        },
        error: function(){
            alert("error");
        }
    });