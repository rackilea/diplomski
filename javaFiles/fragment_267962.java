$.ajax({
    url:"listGmailLabels", // Request that is hitting Gmail API
    type:"POST",
    success:function(data){
        // Success logic goes here
    },
    complete:function(event){
        if(event.status == 504){
            alert('Token expired! Getting a new refresh token.');
            $.ajax({
                url:"clearClientSecret", // service call to cleanup the expired token
                success:function(){
                    window.location.reload();
                }
            })
        }
    }
 });