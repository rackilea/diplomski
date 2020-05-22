oauth2 = require('simple-oauth2')({
    clientID: config.creds.clientID,
    clientSecret: config.creds.clientSecret,
    site: 'https://api.assembla.com',
    authorizationPath: '/authorization',
    tokenPath: '/token'
});

//user hits this route, but doesn't have a auth code, so we redirect
app.get('/', function (req, res) {
    res.redirect('/auth');
});

var authorization_uri = oauth2.authCode.authorizeURL({
    client_id: config.creds.clientID,
    response_type: 'code'
});

app.get('/auth', function (req, res) {
    res.redirect(authorization_uri);
});

//callback url route specifed when you made your app
app.get('/callback', function (req, res) {
    var code = req.query.code;

    //we've got an auth code, 
    //so now we can get a bearer token
    oauth2.authCode.getToken({
        code: code,
        grant_type: 'authorization_code'
    }, saveToken);

    function saveToken(error, result) {
        if (error) { 
            console.log('Access Token Error', error); 
            res.redirect('/');
            return;
        }
        var token = oauth2.accessToken.create(result);
        pullSpaces( res, token );
    }
});

function pullSpaces ( res, token ) {
    request({
        method: 'GET',
        uri: 'https://api.assembla.com/v1/spaces',
        auth: {
            bearer: token.token.access_token
        }
    }, function (error, response, body) {
        //this contains a json object of all the user's spaces
    });

}