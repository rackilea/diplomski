public static native String initiateFilesInput(Element fileUpload, UploadItemWidget imagesPanel)/*-{
    fileUpload.addEventListener("change", fileUpload.addEventListener(
            "change", function(e) {
                showThumbnail(fileUpload.files, imagesPanel);
            }, false));

    function showThumbnail(files, imagesPanel) {

        for ( var i = 0; i < files.length; i++) {
            var file = files[i]
            var image = $doc.createElement("img");
            image.file = file;

            var reader = new FileReader();
            reader.onload = (function(img) {
                return function(e) {
                    img.src = e.target.result;

                    imagesPanel.@fr.onevu.vume.client.common.widget.fileUpload.ImageHolder::addImage(Lcom/google/gwt/dom/client/Element;)(img);
                };
            }(image));

            var ret = reader.readAsDataURL(file);
        }
    }
}-*/;