$(document).ready(function() {                      
            $('#userid').keyup(function(event) {  
                var user=$('#userid').val();
                $.get('CheckValidity',{username:user},function(responseText) { 
                    $('#status').text(responseText);         
                });
            });
        });