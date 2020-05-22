// a callback that has a string for either success or failure
public native void addCallback(Callback<String, String> callback) /*-{
    var callbackFunc = function() {
        // obviously the params could come from the function params
        callback.@com.google.gwt.core.client.Callback::onSuccess(Ljava/lang/String;)("success!");
    };
    doSomethingWith(callbackFunc);//something that takes (and presumably calls) the callback
}-*/;