Node* receiver = kit.argument(0);
if (receiver->Opcode() == Op_ConP) {
  ...
} else {
  print_inlining_failure(C, callee, jvms->depth() - 1, jvms->bci(),
                         "receiver not constant");
}