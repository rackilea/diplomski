GameSettings settings = gson.fromJson( json, GameSettings.class );

String exportedJson = gson.toJson( settings );
if ( !exportedJson.equals( json ) )
{
    Assert.fail();
}