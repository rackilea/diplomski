// Implementation of "inspectheap" command
//
// Input arguments :-
//   arg0: "-live" or "-all"
static jint heap_inspection(AttachOperation* op, outputStream* out) {
  bool live_objects_only = true;   // default is true to retain the behavior before this change is made
  const char* arg0 = op->arg(0);
  if (arg0 != NULL && (strlen(arg0) > 0)) {
    if (strcmp(arg0, "-all") != 0 && strcmp(arg0, "-live") != 0) {
      out->print_cr("Invalid argument to inspectheap operation: %s", arg0);
      return JNI_ERR;
    }
    live_objects_only = strcmp(arg0, "-live") == 0;
  }
  VM_GC_HeapInspection heapop(out, live_objects_only /* request full gc */, true /* need_prologue */);
  VMThread::execute(&heapop);
  return JNI_OK;
}