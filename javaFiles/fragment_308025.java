dojo.provide( "nmpo.io.java" );
dojo.require( "dojo.io.script" );

nmpo.io.java = dojo.delegate( dojo.io.script, { 
    attach: function(/*String*/id, /*String*/url, /*Document?*/frameDocument){
        //  summary:
        //      creates a new  tag pointing to the specified URL and
        //      adds it to the document.
        //  description:
        //      Attaches the script element to the DOM.  Use this method if you
        //      just want to attach a script to the DOM and do not care when or
        //      if it loads.        
        var frame = dojo.create( "iframe", { 
            id: id,
            frameborder:  0,
            framespacing: 0
        }, dojo.body( ) );

        dojo.style( frame, { display: "none" } );
        dojo.attr( frame, { src: url } );
        return frame;
    },

    _makeScriptDeferred: function(/*Object*/args){
        //summary: 
        //      sets up a Deferred object for an IO request.
        var dfd = dojo._ioSetArgs(args, this._deferredCancel, this._deferredOk, this._deferredError);

        var ioArgs = dfd.ioArgs;
        ioArgs.id = dojo._scopeName + "IoScript" + (this._counter++);
        ioArgs.canDelete = false;

        //Special setup for jsonp case
        ioArgs.jsonp = args.callbackParamName || args.jsonp;

        if(ioArgs.jsonp){
            //Add the jsonp parameter.
            ioArgs.query = ioArgs.query || "";
            if(ioArgs.query.length > 0){
                ioArgs.query += "&";
            }
            ioArgs.query += ioArgs.jsonp
                + "="
                + (args.frameDoc ? "parent." : "")
                + "nmpo.io.java.jsonp_" + ioArgs.id + "._jsonpCallback";

            ioArgs.frameDoc = args.frameDoc;

            //Setup the Deferred to have the jsonp callback.
            ioArgs.canDelete = true;
            dfd._jsonpCallback = this._jsonpCallback;
            this["jsonp_" + ioArgs.id] = dfd;
        }
        return dfd; // dojo.Deferred
    }
});