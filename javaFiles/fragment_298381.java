$.ajax
({
    url:"/horn/rest/main/getMessages",
    dataType: "json",
    type: "GET",
    success: function(json)
    {
       $("#supportMessages tr").remove();
       $('#supportMessages').prepend('<tr> ' +
             '<td class="supportColumn"> Status </td>' +
             '</tr>');