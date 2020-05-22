$.ajax({ 
    url: "/updatesetvil", 
    type: "POST",
    // The key needs to match your method's input parameter (case-sensitive).
    data: { jsonString: jsonString},
    contentType: "application/json; charset=utf-8"      
    dataType: "text", 
    success: function(data){ 
        alert(\"success\"+data);
    }, 
    error:function(){ 
        alert(\"failure\"+data); 
    } 
});