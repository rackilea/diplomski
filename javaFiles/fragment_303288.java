function fileUpload()
{
$('#myform').attr('action', 'second.jsp');
    $('#myform').ajaxSubmit({cache:false,success: function a(){
    $('#myform').attr('action', '#');
    }
    });
}