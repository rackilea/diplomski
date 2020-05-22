$.ajax({
        url : '/my_project/rest/runs/1234',
        type : 'POST',
        data: JSON.stringify({ job_position : 38, token: 'moo' }),
        contentType: 'application/json',
        dataType: 'json',
        success : function(html) {
        }
});