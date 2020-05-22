app.get('/:file(*)', function(req, res, next){
    var file = req.params.file, path = __dirname + '/' + file;

    console.log('.');
    res.header('Access-Control-Allow-Origin', '*');

    res.download(path);
});