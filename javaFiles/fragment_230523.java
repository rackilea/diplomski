db.prepare('SELECT COLUMN_1 FROM TABLE_A WHERE COLUMN_2=?', function(err, stmt){
    if(err){
        console.log(err);
    }
    stmt.execute(['CA'], function(err, result){
        result.fetch(function (err, data) {
            if (err) {
                console.error(err);
            }
            console.log(JSON.stringify(data));

            result.closeSync();
        });
    });
});