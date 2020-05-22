$.ajax({
    url: 'target/file.php',
    success: function(response) {
        $("#target-div").html(response);
    }
});