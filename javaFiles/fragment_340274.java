$.ajax({
    url: 'generate',
    type: 'POST',
    contentType: 'text/plain',
    dataType: 'html'
    data: array.join('\n'),
    success: function (data) {
        // data will be html as text
        // This executes only when the request returns successfully.
    }
});