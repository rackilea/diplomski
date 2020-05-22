Stage stage, backStage;
    FitViewport viewport;
    ExtendViewport backViewport;

    ...

    stage = new Stage(); //this is your normal stage you have now
    stage.setViewport( yourFitViewport ); //here you are assingning fit viewport

    backViewport = new ExtendViewport( screenWidth, screenHeight );

    backStage = new Stage();
    backStage.setViewport( backViewport ); 

    ...
    //now add to backStage your background Image

    backStage.addActor( yourBackground );