function openDialogFunc(data){
    if (data.status === 'success') {
        $('#dialog').dialog({
             autoOpen: false,
             width: 600,
             buttons: {
                 "Ok": function() { 
                     $("#myHiddenButtonID").click();
                     $(this).dialog("close"); 
                 }, 
                 "Cancel": function() { 
                     $(this).dialog("close"); 
                 } 
             }
         });
    }
}