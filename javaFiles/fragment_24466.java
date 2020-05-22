function(doc) {
    if (doc && doc.Objects) {
        doc.Objects.forEach(function(obj) {
            emit([obj.code, obj.country], obj);
        });
    }
}