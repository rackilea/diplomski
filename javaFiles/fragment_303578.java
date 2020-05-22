(function() {
    function toJSONString( form ) {
    var obj = {};
    var elements = form.querySelectorAll( "input, select" );
    for( var i = 0; i < elements.length; ++i ) {
        var element = elements[i];
        var name = element.name;
        var value = element.value;

        if( name ) {
            obj[ name ] = value;
        }
    }

    return JSON.stringify( obj );
}

window.onload = function() {
    var form = document.getElementById("test");
    var output = document.getElementById("output");
    form.onsubmit = function( e ) {
        e.preventDefault();
        var json = toJSONString( this );
                console.log(json);
        $.ajax({
            url: form.getAttribute( 'action' ),
            headers: { 
                'Accept': 'application/json',
                'Content-Type': "application/json; charset=utf-8"
            },
            type: 'POST',
            data: json,
            success: function(data) {
                alert("data saved")
            },
            error: function() {
                console.log(errorThrown);
            }
        })
    };
}

})();