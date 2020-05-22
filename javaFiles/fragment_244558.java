address generate_atomic_cmpxchg() {
    StubCodeMark mark(this, "StubRoutines", "atomic_cmpxchg");
    address start = __ pc();

    __ movl(rax, c_rarg2);
   if ( os::is_MP() ) __ lock();
    __ cmpxchgl(c_rarg0, Address(c_rarg1, 0));
    __ ret(0);

    return start;
  }