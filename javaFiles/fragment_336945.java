try{
    req.open( "HEAD", "https://"+url, true );
}
catch( err ){
    req.open( "HEAD", "http://"+url, true );
}