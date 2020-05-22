// src/share/vm/runtime/synchronizer.cpp
static inline intptr_t get_next_hash(Thread * Self, oop obj) {
   ...
   value &= markOopDesc::hash_mask;
   ...
   return value;
}