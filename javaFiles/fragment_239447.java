formPreSubmit: function(event){
  var form = document.getElementById('Form');
    // here you convert to formData calling our function
    var data = this.convertFileInputToFormData();

    form.request.method = "post";
   // set undefined to prevent default json content type
    form.request.contentType = undefined;
   // here you append your formData to the iron-ajax body
    form.request.body = data;
  form.request.url = "http://your.api/url"

  form.request.debounceDuration = 300;
},