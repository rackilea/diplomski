...

var data = new FormData(this);
$.each($formUploader.serializeArray(), function(i, field) {
       data[field.name] = field.value;
});    
//next line will add content of file
data.append('fileContent', $('#file').files[0]);

$.ajax({ ...