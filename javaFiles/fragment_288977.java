$('#imageWrapperTable').DataTable({
        columns:[
            {"data" : "name"},
            {"data" : "type"},
            {"data" : "action"}
        ],
        "processing": true,
        serverSide: true,
        ajax: {
            url: '/getImageWrappers.json',
            type: 'POST',
            datatype: 'json',
            data: function(d){
                 //add your custom param here
                 d.name = "zxbing";

                 //this will put all query strings to a json object string
                 return JSON.stringify(d);
            }
        }
    });