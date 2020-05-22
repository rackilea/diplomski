$.post(
    'jsonServlet', // <- may screw up path here
    { hello: value },
    function(data){
        var table = '<table>';
        for(var i = data.length, l = data.length; i>0; i--){
            // one of over 9000 ways to make js loops work faster
            var person = data[l-i]; // <- this one also does not screw up order
            var row = '<tr>';
            row +='<td>'+person.name+'</td>';
            row +='<td>'+person.id+'</td>';
            row +='<td>'+person.salary+'</td>';
            row +='</tr>';
            table += row;
        }
        table += '</table>';
        $('#myDiv').html(table);
    },
    'json'
);