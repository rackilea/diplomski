void Assembler::prefetch_prefix(Address src) {
  prefix(src);
  emit_int8(0x0F);
}

void Assembler::prefetchnta(Address src) {
  NOT_LP64(assert(VM_Version::supports_sse(), "must support"));
  InstructionMark im(this);
  prefetch_prefix(src);
  emit_int8(0x18);
  emit_operand(rax, src); // 0, src
}

void Assembler::prefetchr(Address src) {
  assert(VM_Version::supports_3dnow_prefetch(), "must support");
  InstructionMark im(this);
  prefetch_prefix(src);
  emit_int8(0x0D);
  emit_operand(rax, src); // 0, src
}

void Assembler::prefetcht0(Address src) {
  NOT_LP64(assert(VM_Version::supports_sse(), "must support"));
  InstructionMark im(this);
  prefetch_prefix(src);
  emit_int8(0x18);
  emit_operand(rcx, src); // 1, src
}

void Assembler::prefetcht1(Address src) {
  NOT_LP64(assert(VM_Version::supports_sse(), "must support"));
  InstructionMark im(this);
  prefetch_prefix(src);
  emit_int8(0x18);
  emit_operand(rdx, src); // 2, src
}

void Assembler::prefetcht2(Address src) {
  NOT_LP64(assert(VM_Version::supports_sse(), "must support"));
  InstructionMark im(this);
  prefetch_prefix(src);
  emit_int8(0x18);
  emit_operand(rbx, src); // 3, src
}

void Assembler::prefetchw(Address src) {
  assert(VM_Version::supports_3dnow_prefetch(), "must support");
  InstructionMark im(this);
  prefetch_prefix(src);
  emit_int8(0x0D);
  emit_operand(rcx, src); // 1, src
}