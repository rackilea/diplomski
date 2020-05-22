// Don’t do it this way!  
 GoogleApiClient gac = new GoogleApiClient.Builder(this, this, this)  
           .addApi(Games.API)  
           .addScope(Plus.SCOPE_PLUS_LOGIN) // The bad part  
           .build();  
 // Don’t do it this way!