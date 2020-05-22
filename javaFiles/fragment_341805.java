Handle java_lang_String::basic_create(int length, TRAPS) {
  assert(initialized, "Must be initialized");
  // Create the String object first, so there's a chance that the String
  // and the char array it points to end up in the same cache line.
  oop obj;
  obj = InstanceKlass::cast(SystemDictionary::String_klass())->allocate_instance(CHECK_NH);

  // Create the char array.  The String object must be handlized here
  // because GC can happen as a result of the allocation attempt.
  Handle h_obj(THREAD, obj);
  typeArrayOop buffer;
    buffer = oopFactory::new_charArray(length, CHECK_NH);

  // Point the String at the char array
  obj = h_obj();
  set_value(obj, buffer);
  // No need to zero the offset, allocation zero'ed the entire String object
  assert(offset(obj) == 0, "initial String offset should be zero");
//set_offset(obj, 0);
  set_count(obj, length);

  return h_obj;
}