$http({
 url : 'services/downloadPDF.jsp',
    dataType: 'json',
    method : 'POST',
    headers : {
        'Content-type' : 'application/pdf',
    },
    data: {data: paramJsonObj},
    responseType : 'arraybuffer'
}).success(function(data, status, headers, config) {
    var file = new Blob([ data ], {
        type : 'application/pdf'
    });
    var fileURL = URL.createObjectURL(file);

    var a         = document.createElement('a');
    a.href        = fileURL; 
    a.target      = '_blank';
    a.download    = 'checklist.pdf';
    document.body.appendChild(a);
    a.click();
}).error(function(err) {
    console.log(err);
});