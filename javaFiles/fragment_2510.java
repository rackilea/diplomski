$.ajax({
        url : '/campaign/holiImageUpload.action',
        type : 'POST',
        data : "image=" + $("#wPaint2").wPaint("image")
        success :function(data){
        }
    });