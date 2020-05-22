function oneMore()

{
    var base64ImageData = "/9j/4AAQSkZJRgABAQEAYABgAAD/2wCEAA0JCgs"
    var formData = reduceImgTransferBandwidth(base64ImageData);

  //   debugger;
    $.ajax({
        url : '/RegisterServlet_2/servlet/Register',
        type : "POST",
        data : formData,
           enctype: 'multipart/form-data',
        processData : false,
        contentType : false
    }).done(function(data)
    {
        //alert('File upload completed ...');
    }).fail(function(jqXHR, textStatus)
    {
        //alert('File upload failed ...');
    });
}



    function reduceImgTransferBandwidth(pimagedata)
    {
        var form = document.createElement("myForm");
        var ImageURL = "data:image/gif;base64," + pimagedata;
        var block = ImageURL.split(";");
        var contentType = block[0].split(":")[1];
        var realData = block[1].split(",")[1];
        var blob = b64toBlob(realData, contentType);
        var formDataToUpload = new FormData(form);

        formDataToUpload.append("image", blob);

        return formDataToUpload;

    }

    function b64toBlob(b64Data, contentType, sliceSize)
    {
        contentType = contentType || '';
        sliceSize = sliceSize || 512;

        var byteCharacters = atob(b64Data);
        var byteArrays = [];

        for (var offset = 0; offset < byteCharacters.length; offset += sliceSize)
        {
            var slice = byteCharacters.slice(offset, offset + sliceSize);

            var byteNumbers = new Array(slice.length);
            for (var i = 0; i < slice.length; i++)
            {
                byteNumbers[i] = slice.charCodeAt(i);
            }

            var byteArray = new Uint8Array(byteNumbers);

            byteArrays.push(byteArray);
        }

        var blob = new Blob(byteArrays, {
            type : contentType
        });
        return blob;
    }