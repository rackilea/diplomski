if (!window.Clipboard) {
   var pasteCatcher = document.createElement("apDiv1");
   pasteCatcher.setAttribute("contenteditable", "");
   pasteCatcher.style.opacity = 0;
   document.body.appendChild(pasteCatcher);
   pasteCatcher.focus();
   document.addEventListener("click", function() { pasteCatcher.focus(); });
} 

window.addEventListener("paste", onPasteHandler);

function onPasteHandler(e)
{
    if(e.clipboardData) {
        var items = e.clipboardData.items;
        if(!items){
            alert("Image Not found");
        }
        for (var i = 0; i < items.length; ++i) {
        if (items[i].kind === 'file' && items[i].type === 'image/png') {
            var blob = items[i].getAsFile(),
                source = window.webkitURL.createObjectURL(blob);

            pastedImage = new Image();
            pastedImage.src = source;

            pasteData();
            }
        }
    }
}

function pasteData()
{
    drawCanvas = document.getElementById('drawCanvas1');
    ctx = drawCanvas.getContext( '2d' );
    ctx.clearRect(0, 0, 640,480);
    ctx.drawImage(pastedImage, 0, 0);
}