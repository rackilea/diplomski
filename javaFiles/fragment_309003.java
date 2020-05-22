function initSuggest(){
    var cache = {},
        lastXhr;
    $( ".Mjesto" ).each( function() {
        $( this ).autocomplete( {
            minLength: 2,
            source: function( request, response ) {
                var sourceId = $("#DrzavaId option:selected").text();
                var term = request.term;
                if ( term in cache ) {
                    response( cache[term] );
                } else {
                    try {
                        lastXhr = $.getJSON( "autocomplete2.cfm", { c: sourceId, t: term }, 
                            function( data, status, xhr ) {
                                cache[term] = data;
                                if ( xhr === lastXhr ) {
                                response( data );
                            }
                        });
                    } catch( ex ) {
                        response( null );
                    }
                }
            },
            autoFocus: true
        } );
    } );
}