select filter(heap.objects(), function(it) {
  var cls = classof(it);
  while (cls) {
    for (var i = 0; i < cls.fields.length; i++) {
      var field = cls.fields[i];
      if (field.signature == 'F' && it[field.name] == 0.0)
        return true;
      }
    cls = cls.superclass;
  }
  return false;
})