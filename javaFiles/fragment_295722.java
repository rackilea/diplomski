# {method} {0x0000000016da0810} 'AndSC' '(III)Z' in 'AndTest'
  ...
  0x0000000002923e3e: cmp    %r8d,%r9d
  0x0000000002923e41: movabs $0x16da0a08,%rax   ;   {metadata(method data for {method} {0x0000000016da0810} 'AndSC' '(III)Z' in 'AndTest')}
  0x0000000002923e4b: movabs $0x108,%rsi
  0x0000000002923e55: jl     0x0000000002923e65
  0x0000000002923e5b: movabs $0x118,%rsi
  0x0000000002923e65: mov    (%rax,%rsi,1),%rbx
  0x0000000002923e69: lea    0x1(%rbx),%rbx
  0x0000000002923e6d: mov    %rbx,(%rax,%rsi,1)
  0x0000000002923e71: jl     0x0000000002923eb0  ;*if_icmplt
                                                ; - AndTest::AndSC@2 (line 22)

  0x0000000002923e77: cmp    %edi,%r9d
  0x0000000002923e7a: movabs $0x16da0a08,%rax   ;   {metadata(method data for {method} {0x0000000016da0810} 'AndSC' '(III)Z' in 'AndTest')}
  0x0000000002923e84: movabs $0x128,%rsi
  0x0000000002923e8e: jg     0x0000000002923e9e
  0x0000000002923e94: movabs $0x138,%rsi
  0x0000000002923e9e: mov    (%rax,%rsi,1),%rdi
  0x0000000002923ea2: lea    0x1(%rdi),%rdi
  0x0000000002923ea6: mov    %rdi,(%rax,%rsi,1)
  0x0000000002923eaa: jle    0x0000000002923ec1  ;*if_icmpgt
                                                ; - AndTest::AndSC@7 (line 22)

  0x0000000002923eb0: mov    $0x0,%eax
  0x0000000002923eb5: add    $0x30,%rsp
  0x0000000002923eb9: pop    %rbp
  0x0000000002923eba: test   %eax,-0x1c73dc0(%rip)        # 0x0000000000cb0100
                                                ;   {poll_return}
  0x0000000002923ec0: retq                      ;*ireturn
                                                ; - AndTest::AndSC@13 (line 25)

  0x0000000002923ec1: mov    $0x1,%eax
  0x0000000002923ec6: add    $0x30,%rsp
  0x0000000002923eca: pop    %rbp
  0x0000000002923ecb: test   %eax,-0x1c73dd1(%rip)        # 0x0000000000cb0100
                                                ;   {poll_return}
  0x0000000002923ed1: retq