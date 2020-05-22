$(document).ready(function() {
        $("button").click(function() {
            $.post("login",{
                 name:"kevin",
                 pass:"Duckburg"
             }).done(function( data ) {
                  alert( "name: " + data );
             })
         });
});