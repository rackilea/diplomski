$.ajax({
    url: '/TestProj/Controller',
    type: 'POST',
    dataType: 'json',
    data: 'action=checkuname&jsonObject=' + JSON.stringify(udata),
    success: function(data){
        checkstatus = data.status;
    },
    error: function(x,y,z){ console.log(JSON.stringify(x)); }
});