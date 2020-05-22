$( "#vut" ).on( "click", function(e){
    e.preventDefault();
    e.stopPropagation();
    $.ajax({
           url: '/messagechat',
           method: 'POST',
           dataType: 'json',
           data: JSON.stringify({message: 'a'})
    });
});