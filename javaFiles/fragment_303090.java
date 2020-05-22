$.ajax({
    url: 'akuiteoMap',
    method: 'POST',
    dataType: 'json',
    contentType: 'application/json',,
    data : JSON.stringify(commits),
    // ----^^^^^^^^^^^^^^^^^^^^^^^----
    success: function(data){
        console.log(data);
    }
})