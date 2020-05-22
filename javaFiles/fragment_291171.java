315           if (key == null)
316               return getForNullKey();
...
322               if (e.hash == hash &&
                      ((k = e.key) == key || key.equals(k)))
323                   return e.value;