Decoding compiled method 0x00007f2e2910ac90:
Code:
[Entry Point]
[Constants]
  # {method} {0x00007f2e27121230} 'printMe' '()V' in 'com/vs/soutils/Test3'
  #           [sp+0x40]  (sp of caller)
  0x00007f2e2910ae00: mov    0x8(%rsi),%r10d
  0x00007f2e2910ae04: shl    $0x3,%r10
  0x00007f2e2910ae08: cmp    %rax,%r10
  0x00007f2e2910ae0b: jne    0x00007f2e29045b60  ;   {runtime_call}
  0x00007f2e2910ae11: nopw   0x0(%rax,%rax,1)
  0x00007f2e2910ae1c: xchg   %ax,%ax
[Verified Entry Point]
  0x00007f2e2910ae20: mov    %eax,-0x14000(%rsp)
  0x00007f2e2910ae27: push   %rbp
  0x00007f2e2910ae28: sub    $0x30,%rsp
  0x00007f2e2910ae2c: mov    $0x7f2e271213f8,%rdi  ;   {metadata(method data for {method} {0x00007f2e27121230} 'printMe' '()V' in 'com/vs/soutils/Test3')}
  0x00007f2e2910ae36: mov    0x64(%rdi),%ebx
  0x00007f2e2910ae39: add    $0x8,%ebx
  0x00007f2e2910ae3c: mov    %ebx,0x64(%rdi)
  0x00007f2e2910ae3f: mov    $0x7f2e27121230,%rdi  ;   {metadata({method} {0x00007f2e27121230} 'printMe' '()V' in 'com/vs/soutils/Test3')}
  0x00007f2e2910ae49: and    $0x1ff8,%ebx
  0x00007f2e2910ae4f: cmp    $0x0,%ebx
  0x00007f2e2910ae52: je     0x00007f2e2910aec0  ;*aload_0
                                                ; - com.vs.soutils.Test3::printMe@0 (line 6)

  0x00007f2e2910ae58: mov    %rsi,%rdi
  0x00007f2e2910ae5b: mov    $0x7f2e271213f8,%rbx  ;   {metadata(method data for {method} {0x00007f2e27121230} 'printMe' '()V' in 'com/vs/soutils/Test3')}
  0x00007f2e2910ae65: addq   $0x1,0xa0(%rbx)
  0x00007f2e2910ae6d: mov    $0x7f2e271213f8,%rdi  ;   {metadata(method data for {method} {0x00007f2e27121230} 'printMe' '()V' in 'com/vs/soutils/Test3')}
  0x00007f2e2910ae77: mov    0x64(%rdi),%ebx
  0x00007f2e2910ae7a: add    $0x8,%ebx
  0x00007f2e2910ae7d: mov    %ebx,0x64(%rdi)
  0x00007f2e2910ae80: mov    $0x7f2e27121230,%rdi  ;   {metadata({method} {0x00007f2e27121230} 'printMe' '()V' in 'com/vs/soutils/Test3')}
  0x00007f2e2910ae8a: and    $0x7ffff8,%ebx
  0x00007f2e2910ae90: cmp    $0x0,%ebx
  0x00007f2e2910ae93: je     0x00007f2e2910aed4
  0x00007f2e2910ae99: mov    %rsi,%rdi
  0x00007f2e2910ae9c: mov    $0x7f2e271213f8,%rbx  ;   {metadata(method data for {method} {0x00007f2e27121230} 'printMe' '()V' in 'com/vs/soutils/Test3')}
  0x00007f2e2910aea6: addq   $0x1,0xa0(%rbx)
  0x00007f2e2910aeae: nop    
  0x00007f2e2910aeaf: callq  0x00007f2e29045d60  ; OopMap{off=180}
                                                ;*invokevirtual printMe
                                                ; - com.vs.soutils.Test3::printMe@1 (line 6)
                                                ; - com.vs.soutils.Test3::printMe@1 (line 6)
                                                ;   {optimized virtual_call}
  0x00007f2e2910aeb4: add    $0x30,%rsp
  0x00007f2e2910aeb8: pop    %rbp
  0x00007f2e2910aeb9: test   %eax,0x16461241(%rip)        # 0x00007f2e3f56c100
                                                ;   {poll_return}
  0x00007f2e2910aebf: retq   
  0x00007f2e2910aec0: mov    %rdi,0x8(%rsp)
  0x00007f2e2910aec5: movq   $0xffffffffffffffff,(%rsp)
  0x00007f2e2910aecd: callq  0x00007f2e290fdde0  ; OopMap{rsi=Oop off=210}
                                                ;*synchronization entry
                                                ; - com.vs.soutils.Test3::printMe@-1 (line 6)
                                                ;   {runtime_call}
  0x00007f2e2910aed2: jmp    0x00007f2e2910ae58
  0x00007f2e2910aed4: mov    %rdi,0x8(%rsp)
  0x00007f2e2910aed9: movq   $0xffffffffffffffff,(%rsp)
  0x00007f2e2910aee1: callq  0x00007f2e290fdde0  ; OopMap{rsi=Oop off=230}
                                                ;*synchronization entry
                                                ; - com.vs.soutils.Test3::printMe@-1 (line 6)
                                                ; - com.vs.soutils.Test3::printMe@1 (line 6)
                                                ;   {runtime_call}
  0x00007f2e2910aee6: jmp    0x00007f2e2910ae99
  0x00007f2e2910aee8: nop    
  0x00007f2e2910aee9: nop    
  0x00007f2e2910aeea: mov    0x288(%r15),%rax
  0x00007f2e2910aef1: mov    $0x0,%r10
  0x00007f2e2910aefb: mov    %r10,0x288(%r15)
  0x00007f2e2910af02: mov    $0x0,%r10
  0x00007f2e2910af0c: mov    %r10,0x290(%r15)
  0x00007f2e2910af13: add    $0x30,%rsp
  0x00007f2e2910af17: pop    %rbp
  0x00007f2e2910af18: jmpq   0x00007f2e2906be20  ;   {runtime_call}