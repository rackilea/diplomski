$.ajax({
    type : 'POST',
    url : '/processUpload',
    data : formData,
    dataType : 'text',
    cache : false,
    processData : false,
    contentType : false,
    xhr : function () {
        ... progress things ...
    }
});