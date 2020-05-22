instruct strictfp_mulD_reg(regDPR1 dst, regnotDPR1 src) %{
  predicate( UseSSE<=1 && Compile::current()->has_method() && Compile::current()
->method()->is_strict() );
  match(Set dst (MulD dst src));
  ins_cost(1);   // Select this instruction for all strict FP double multiplies

  format %{ "FLD    StubRoutines::_fpu_subnormal_bias1\n\t"
            "DMULp  $dst,ST\n\t"
            "FLD    $src\n\t"
            "DMULp  $dst,ST\n\t"
            "FLD    StubRoutines::_fpu_subnormal_bias2\n\t"
            "DMULp  $dst,ST\n\t" %}
  opcode(0xDE, 0x1); /* DE C8+i or DE /1*/
  ins_encode( strictfp_bias1(dst),
              Push_Reg_D(src),
              OpcP, RegOpc(dst),
              strictfp_bias2(dst) );
  ins_pipe( fpu_reg_reg );
%}

instruct strictfp_divD_reg(regDPR1 dst, regnotDPR1 src) %{
  predicate (UseSSE<=1);
  match(Set dst (DivD dst src));
  predicate( UseSSE<=1 && Compile::current()->has_method() && Compile::current()
->method()->is_strict() );
  ins_cost(01);

  format %{ "FLD    StubRoutines::_fpu_subnormal_bias1\n\t"
            "DMULp  $dst,ST\n\t"
            "FLD    $src\n\t"
            "FDIVp  $dst,ST\n\t"
            "FLD    StubRoutines::_fpu_subnormal_bias2\n\t"
            "DMULp  $dst,ST\n\t" %}
  opcode(0xDE, 0x7); /* DE F8+i or DE /7*/
  ins_encode( strictfp_bias1(dst),
              Push_Reg_D(src),
              OpcP, RegOpc(dst),
              strictfp_bias2(dst) );
  ins_pipe( fpu_reg_reg );
%}