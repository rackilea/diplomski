RealmDbGenerator dbGenerator = new RealmDbGenerator(this);    

    //flags
    dbGenerator.setGenerationStrategy(new FlagDefStrategy());
    dbGenerator.addData(FILE_FLAGS,SEPARATOR);

    //pictures
    dbGenerator.setGenerationStrategy(new PictureStrategy());
    dbGenerator.addData(FILE_PICTURES,SEPARATOR);