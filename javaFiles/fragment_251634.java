app.use (function(req, res, next) {
    var data='';
    req.setEncoding('utf8');
    req.on('data', function(chunk) { 
       data += chunk;
   });

   req.on('end', function() {
       req.body = data;
       next();
   });
});

app.post('/', function(req, res) {
    // you have set the body before:
    console.log(req.body);
});