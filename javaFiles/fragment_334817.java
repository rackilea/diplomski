void
G1CollectedHeap::
g1_process_strong_roots(bool collecting_perm_gen,
                        SharedHeap::ScanningOption so,
                        OopClosure* scan_non_heap_roots,
                        OopsInHeapRegionClosure* scan_rs,
                        OopsInGenClosure* scan_perm,
                        int worker_i) {
  //...
  process_strong_roots(false, // no scoping; this is parallel code
                       collecting_perm_gen, so,
                       &buf_scan_non_heap_roots,
                       &eager_scan_code_roots,
                       &buf_scan_perm);
  //...
}