dojo.require( "nmpo.io.java" );
nmpo.io.java.get({
    // For some reason the first paramater (the one after the '?') is never in the
    // paramater array in the java runtime. As a work around we stick in a dummy.
    url: "command://sum?_",
    callbackParamName: "callback",
    content: {
        numbers: [ 1, 2, 3, 4, 5 ].join( "," )
    },
    load: function( result ){
        console.log( "A result was returned, the sum was [ " + result.result + " ]" );  
    }   
});