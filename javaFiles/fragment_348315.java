...

var data = new FormData(this);
$.each($formUploader.serializeArray(), function(i, field) {
       data[field.name] = field.value;
});    

$.each($('#file').files, function(i, file) {
    formData.append('fileContent' + i, file);
});

$.ajax({ ...