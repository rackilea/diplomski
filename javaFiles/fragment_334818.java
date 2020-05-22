for (JNIHandleBlock* current = current_chain; current != NULL;
     current = current->_next) {
  assert(current == current_chain || current->pop_frame_link() == NULL,
    "only blocks first in chain should have pop frame link set");
  for (int index = 0; index < current->_top; index++) {
    oop* root = &(current->_handles)[index];
    oop value = *root;
    // traverse heap pointers only, not deleted handles or free list
    // pointers
    if (value != NULL && Universe::heap()->is_in_reserved(value)) {
      f->do_oop(root);
    }
  }
  // the next handle block is valid only if current block is full
  if (current->_top < block_size_in_oops) {
    break;
  }
}