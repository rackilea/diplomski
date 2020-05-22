val data2 = Pointer.pointerToPointer(data);
ret = Netfilter_queueLibrary.nfq_get_payload(tb, data2)
if (ret >= 0) {
  println(String.format(" payload_len=%d ", ret));
  println("data: ");
  for (i <- 0 until ret) {
    printf("%02x", (data2.get().getBytes(ret)(i)));
  }