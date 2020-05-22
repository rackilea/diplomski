static int32_t max_array_length(BasicType type) {
  assert(type >= 0 && type < T_CONFLICT, "wrong type");
  assert(type2aelembytes[type] != 0, "wrong type");
  // We use max_jint, since object_size is internally represented by an 'int'
  // This gives us an upper bound of max_jint words for the size of the oop.
  int32_t max_words = (max_jint - header_size(type) - 2);
  int elembytes = (type == T_OBJECT) ? T_OBJECT_aelem_bytes : type2aelembytes[type];
  jlong len = ((jlong)max_words * HeapWordSize) / elembytes;
  return (len > max_jint) ? max_jint : (int32_t)len;
}