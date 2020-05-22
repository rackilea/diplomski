//This doesnt look that bad?
if (settingsChanged){
    read().setHandler(arRead -> { 
        if (arRead.succeeded()) handler.handle(arRead.result()); 
    });
}