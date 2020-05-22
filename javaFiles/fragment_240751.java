MyJavascriptClass = Class.create({

    initialize: function(textField, someParam) 
    {
        this.textField = $(textField);
        this.someParam = someParam;

        this.textField.observe('focus', this.onFocus.bindAsEventListener(this));
    },

    onFocus: function(event)
    {
        //do something
    }
}