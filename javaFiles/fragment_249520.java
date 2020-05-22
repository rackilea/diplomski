new Ajax.Request(url, {
        method: 'post',
        parameters: params,
        onComplete: function(response) {
            var img = new Image();
            img.src = "data:image/png;base64," + response;

            document.body.appendChild(img);
        }
});