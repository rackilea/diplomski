select s from java.util.concurrent.ConcurrentHashMap s where contains(s.segments, function(it) {
    if (!it || !it.table) {
        return false;
    }
    var i, e;
    for (i=0; i < it.table.length; i = i + 1) {
        e = it.table[i];
        if (e) {
            return e.key && e.key.value && e.key.value.toString() == 'test';
        }
    }
    return false;
})