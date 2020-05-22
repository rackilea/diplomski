try this may work for you

$.ajax({
                    type: "POST",
                    url: 'http://localhost:8080/IDNS_Rule_Configuration/idns/idnsData/importYaml',
                    enctype: "multipart/form-data",
                    data: formData,
                    processData: false,  
                    contentType: false,
                    success: function (data) {
    //some success functions
    }
    });