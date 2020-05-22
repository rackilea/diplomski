<script>
$(document).on("click", "#submit", function() { 
    var value = $('#val').val(); //get value you want to send
    var params = {value : value}; //set it as one of the parameters

    $.post("FormList", $.param(params), function(response) { //make ajax request
                 $('#res').text(response); //retrieve response and set it to #res
    });
        });
</script>