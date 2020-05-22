function ajaxPoll(){
     $.ajax({
                                        url: "mcrs/object/api/Lighting",
                                        type: "POST",
                                        traditional: true,
                                        dataType: "json",                                        
                                        contentType: "application/x-www-form-urlencoded",
                                        async: "false",
                                        data:JSON.stringify(postdata),                                    
                                        success: function (ResData) {
                                            tag.str = 'Status : ' + '' + ResData.status + '';
                                        },
                                        error: function (error, data) {
                                            console.log(error);
                                        }
                                    });                                
                                }       
                            });  
}

setInterval(ajaxPoll, 2000);