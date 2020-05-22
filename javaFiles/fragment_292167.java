function closeDialogIfSucess(xhr, status, args, createWidget) {
    if(args.validationFailed || !args.loggedIn) {  
        jQuery('#testDialog').effect("shake", { times:3 }, 100);  
    } else {  
        createWidget.hide();  
    }  
}