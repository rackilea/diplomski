HttpRequest req = new HttpRequest();
req.setMethod('POST');
req.setHeader('Content-Type','application/x-www-form-urlencoded');
req.setEndpoint('https://ap5.salesforce.com/services/oauth2/token');

String CLIENT_ID = 'XXXXXXXXXXXXXXXXXXXXXXXXX';
String CLIENT_SECRET = 'XXXXXXXXXXXXXXXXXXXXXXX';
String USERNAME = 'XXXXXXXXXXXXXX';
String PASSWORD = 'XXXXXXXXXXXXXX';

req.setBody('grant_type=password' + '&client_id='+CLIENT_ID + 
            '&client_secret='+CLIENT_SECRET + '&username='+USERNAME + '&password='+PASSWORD);

Http http = new Http();
HTTPResponse response = http.send(req);
System.debug('Body ' + response.getBody());
System.debug('Status ' + response.getStatus());
System.debug('Status code ' + response.getStatusCode());