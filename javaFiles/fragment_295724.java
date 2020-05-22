# {method} {0x0000000016da0908} 'AndNonSC' '(III)Z' in 'AndTest'
  ...
  0x0000000002923a78: cmp    %r8d,%r9d
  0x0000000002923a7b: mov    $0x0,%eax
  0x0000000002923a80: jl     0x0000000002923a8b
  0x0000000002923a86: mov    $0x1,%eax
  0x0000000002923a8b: cmp    %edi,%r9d
  0x0000000002923a8e: mov    $0x0,%esi
  0x0000000002923a93: jg     0x0000000002923a9e
  0x0000000002923a99: mov    $0x1,%esi
  0x0000000002923a9e: and    %rsi,%rax
  0x0000000002923aa1: cmp    $0x0,%eax
  0x0000000002923aa4: je     0x0000000002923abb  ;*ifeq
                                                ; - AndTest::AndNonSC@21 (line 29)

  0x0000000002923aaa: mov    $0x1,%eax
  0x0000000002923aaf: add    $0x30,%rsp
  0x0000000002923ab3: pop    %rbp
  0x0000000002923ab4: test   %eax,-0x1c739ba(%rip)        # 0x0000000000cb0100
                                                ;   {poll_return}
  0x0000000002923aba: retq                      ;*ireturn
                                                ; - AndTest::AndNonSC@25 (line 30)

  0x0000000002923abb: mov    $0x0,%eax
  0x0000000002923ac0: add    $0x30,%rsp
  0x0000000002923ac4: pop    %rbp
  0x0000000002923ac5: test   %eax,-0x1c739cb(%rip)        # 0x0000000000cb0100
                                                ;   {poll_return}
  0x0000000002923acb: retq