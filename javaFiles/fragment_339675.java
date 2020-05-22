Object value = field.get(table);
// gets the value of this field for the instance 'table'

log += "value: " + value + "\n";
// implicitly uses toString for you
// or will put 'null' if the object is null