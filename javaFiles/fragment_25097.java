void LIR_Assembler::emit_op1(LIR_Op1* op) {
  switch (op->code()) { 
...
    case lir_prefetchr:
      prefetchr(op->in_opr());
      break;

    case lir_prefetchw:
      prefetchw(op->in_opr());
      break;