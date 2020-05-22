$('textarea[name*="matterData.customFields"]').each(function () {
     var text = $(this).val();
     text = text.replace(/\n/g, "\r\n");
     if(text.length >= 255){
        a = text.substring(0, 254);
        $(this).val(a);
     }
//...
}