$.ajax({
    url: 'AdimnProductFilterAction?pgIndex='+para,
    cache: false,
    success: function (data) {
        $.each(data, function (key, value) {
            $('#proFilterTab').html(value.d1);
            $('#pagId').html(value.d2);
        });
    },
    error: function () {
        alert('error');
    }
});