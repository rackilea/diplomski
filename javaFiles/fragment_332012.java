protected MongoClientOptions getOptions(){
    MongoClientOptions mClientOpts;
    Builder mClientOptionsBuilder = new MongoClientOptions.Builder();
    mClientOptionsBuilder.readPreference(ReadPreference.nearest());
    mClientOpts = mClientOptionsBuilder.build(); 
    System.out.println("[MongoConfig]: " + mClientOpts.toString());

    return mClientOpts;
}