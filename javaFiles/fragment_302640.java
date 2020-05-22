function testMethod(value)
{
    var form = $('#form');
    if(serviceName != null && form.length)
    {
        $('#input').val(value);
        form.attr('action', $('#newAction').val());
        form.submit();
    }
}