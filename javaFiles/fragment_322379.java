select s from java.util.HashMap s where contains(s.table, function(it) {
    if (it && it.key && it.key.value && it.key.value.toString() == 'test') {
        return true;
    }
    return false;
})