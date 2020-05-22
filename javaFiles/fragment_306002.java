void objArrayKlass::copy_array(arrayOop s, int src_pos, arrayOop d,
                           int dst_pos, int length, TRAPS) {
assert(s->is_objArray(), "must be obj array");

if (!d->is_objArray()) {
  THROW(vmSymbols::java_lang_ArrayStoreException());
}

// Check is all offsets and lengths are non negative
if (src_pos < 0 || dst_pos < 0 || length < 0) {
  THROW(vmSymbols::java_lang_ArrayIndexOutOfBoundsException());
}
// Check if the ranges are valid
if  ( (((unsigned int) length + (unsigned int) src_pos) > (unsigned int) s->length())
   || (((unsigned int) length + (unsigned int) dst_pos) > (unsigned int) d->length()) )   {
  THROW(vmSymbols::java_lang_ArrayIndexOutOfBoundsException());
}

// Special case. Boundary cases must be checked first
// This allows the following call: copy_array(s, s.length(), d.length(), 0).
// This is correct, since the position is supposed to be an 'in between point', i.e., s.length(),
// points to the right of the last element.
if (length==0) {
  return;
}
if (UseCompressedOops) {
  narrowOop* const src = objArrayOop(s)->obj_at_addr<narrowOop>(src_pos);
  narrowOop* const dst = objArrayOop(d)->obj_at_addr<narrowOop>(dst_pos);
  do_copy<narrowOop>(s, src, d, dst, length, CHECK);
} else {
  oop* const src = objArrayOop(s)->obj_at_addr<oop>(src_pos);
  oop* const dst = objArrayOop(d)->obj_at_addr<oop>(dst_pos);
  do_copy<oop> (s, src, d, dst, length, CHECK);
  }
}