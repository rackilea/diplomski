$ java -Xcomp -XX:-TieredCompilation -XX:CompileCommand=print,Main.f Main

  0x00000000025ab460: mov    %eax,-0x6000(%rsp)    ; StackOverflow check
  0x00000000025ab467: push   %rbp                  ; frame link
  0x00000000025ab468: sub    $0x10,%rsp            
  0x00000000025ab46c: movabs $0xd7726ef0,%r10      ; r10 = Main.class
  0x00000000025ab476: addl   $0x2,0x68(%r10)       ; Main.counter += 2
  0x00000000025ab47b: callq  0x00000000023c6620    ; invokestatic f()
  0x00000000025ab480: add    $0x10,%rsp
  0x00000000025ab484: pop    %rbp                  ; pop frame
  0x00000000025ab485: test   %eax,-0x23bb48b(%rip) ; safepoint poll
  0x00000000025ab48b: retq