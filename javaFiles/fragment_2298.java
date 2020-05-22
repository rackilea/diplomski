Decoding compiled method 0x00007fea24ef0dd0:
Code:
[Entry Point]
[Constants]
  # {method} {0x00007fea229431b0} '<init>' '()V' in 'com/vs/soutils/Test'
  #           [sp+0x80]  (sp of caller)
  0x00007fea24ef0f60: mov    0x8(%rsi),%r10d
  0x00007fea24ef0f64: shl    $0x3,%r10
  0x00007fea24ef0f68: cmp    %rax,%r10
  0x00007fea24ef0f6b: jne    0x00007fea24e29b60  ;   {runtime_call}
  0x00007fea24ef0f71: nopw   0x0(%rax,%rax,1)
  0x00007fea24ef0f7c: xchg   %ax,%ax
[Verified Entry Point]
  0x00007fea24ef0f80: mov    %eax,-0x14000(%rsp)
  0x00007fea24ef0f87: push   %rbp
  0x00007fea24ef0f88: sub    $0x70,%rsp
  0x00007fea24ef0f8c: mov    $0x7fea22943350,%rdx  ;   {metadata(method data for {method} {0x00007fea229431b0} '<init>' '()V' in 'com/vs/soutils/Test')}
  0x00007fea24ef0f96: mov    0x64(%rdx),%edi
  0x00007fea24ef0f99: add    $0x8,%edi
  0x00007fea24ef0f9c: mov    %edi,0x64(%rdx)
  0x00007fea24ef0f9f: mov    $0x7fea229431b0,%rdx  ;   {metadata({method} {0x00007fea229431b0} '<init>' '()V' in 'com/vs/soutils/Test')}
  0x00007fea24ef0fa9: and    $0x1ff8,%edi
  0x00007fea24ef0faf: cmp    $0x0,%edi
  0x00007fea24ef0fb2: je     0x00007fea24ef1172  ;*aload_0
                                                ; - com.vs.soutils.Test::<init>@0 (line 3)

  0x00007fea24ef0fb8: mov    %rsi,%rdx
  0x00007fea24ef0fbb: mov    $0x7fea22943350,%rdi  ;   {metadata(method data for {method} {0x00007fea229431b0} '<init>' '()V' in 'com/vs/soutils/Test')}
  0x00007fea24ef0fc5: addq   $0x1,0x90(%rdi)
  0x00007fea24ef0fcd: mov    $0x7fea226a1f10,%rdx  ;   {metadata(method data for {method} {0x00007fea22543488} '<init>' '()V' in 'java/lang/Object')}
  0x00007fea24ef0fd7: mov    0x64(%rdx),%edi
  0x00007fea24ef0fda: add    $0x8,%edi
  0x00007fea24ef0fdd: mov    %edi,0x64(%rdx)
  0x00007fea24ef0fe0: mov    $0x7fea22543488,%rdx  ;   {metadata({method} {0x00007fea22543488} '<init>' '()V' in 'java/lang/Object')}
  0x00007fea24ef0fea: and    $0x7ffff8,%edi
  0x00007fea24ef0ff0: cmp    $0x0,%edi
  0x00007fea24ef0ff3: je     0x00007fea24ef1189
  0x00007fea24ef0ff9: mov    $0x7c0060028,%rdx  ;   {metadata('com/vs/soutils/Test')}
  0x00007fea24ef1003: mov    %rsi,0x58(%rsp)
  0x00007fea24ef1008: mov    0x60(%r15),%rax
  0x00007fea24ef100c: lea    0x10(%rax),%rdi
  0x00007fea24ef1010: cmp    0x70(%r15),%rdi
  0x00007fea24ef1014: ja     0x00007fea24ef11a0
  0x00007fea24ef101a: mov    %rdi,0x60(%r15)
  0x00007fea24ef101e: mov    0xa8(%rdx),%rcx
  0x00007fea24ef1025: mov    %rcx,(%rax)
  0x00007fea24ef1028: mov    %rdx,%rcx
  0x00007fea24ef102b: shr    $0x3,%rcx
  0x00007fea24ef102f: mov    %ecx,0x8(%rax)
  0x00007fea24ef1032: xor    %rcx,%rcx
  0x00007fea24ef1035: mov    %ecx,0xc(%rax)
  0x00007fea24ef1038: xor    %rcx,%rcx          ;*new  ; - com.vs.soutils.Test::<init>@5 (line 5)

  0x00007fea24ef103b: mov    %rax,%rdx
  0x00007fea24ef103e: mov    $0x7fea22943350,%rsi  ;   {metadata(method data for {method} {0x00007fea229431b0} '<init>' '()V' in 'com/vs/soutils/Test')}
  0x00007fea24ef1048: addq   $0x1,0xa0(%rsi)
  0x00007fea24ef1050: mov    $0x7fea22943350,%rdx  ;   {metadata(method data for {method} {0x00007fea229431b0} '<init>' '()V' in 'com/vs/soutils/Test')}
  0x00007fea24ef105a: mov    0x64(%rdx),%esi
  0x00007fea24ef105d: add    $0x8,%esi
  0x00007fea24ef1060: mov    %esi,0x64(%rdx)
  0x00007fea24ef1063: mov    $0x7fea229431b0,%rdx  ;   {metadata({method} {0x00007fea229431b0} '<init>' '()V' in 'com/vs/soutils/Test')}
  0x00007fea24ef106d: and    $0x7ffff8,%esi
  0x00007fea24ef1073: cmp    $0x0,%esi
  0x00007fea24ef1076: je     0x00007fea24ef11ad
  0x00007fea24ef107c: mov    %rax,%rdx
  0x00007fea24ef107f: mov    $0x7fea22943350,%rsi  ;   {metadata(method data for {method} {0x00007fea229431b0} '<init>' '()V' in 'com/vs/soutils/Test')}
  0x00007fea24ef1089: addq   $0x1,0x90(%rsi)
  0x00007fea24ef1091: mov    $0x7fea226a1f10,%rdx  ;   {metadata(method data for {method} {0x00007fea22543488} '<init>' '()V' in 'java/lang/Object')}
  0x00007fea24ef109b: mov    0x64(%rdx),%esi
  0x00007fea24ef109e: add    $0x8,%esi
  0x00007fea24ef10a1: mov    %esi,0x64(%rdx)
  0x00007fea24ef10a4: mov    $0x7fea22543488,%rdx  ;   {metadata({method} {0x00007fea22543488} '<init>' '()V' in 'java/lang/Object')}
  0x00007fea24ef10ae: and    $0x7ffff8,%esi
  0x00007fea24ef10b4: cmp    $0x0,%esi
  0x00007fea24ef10b7: je     0x00007fea24ef11c4
  0x00007fea24ef10bd: mov    $0x7c0060028,%rdx  ;   {metadata('com/vs/soutils/Test')}
  0x00007fea24ef10c7: mov    %rax,0x50(%rsp)
  0x00007fea24ef10cc: mov    0x60(%r15),%rax
  0x00007fea24ef10d0: lea    0x10(%rax),%rdi
  0x00007fea24ef10d4: cmp    0x70(%r15),%rdi
  0x00007fea24ef10d8: ja     0x00007fea24ef11db
  0x00007fea24ef10de: mov    %rdi,0x60(%r15)
  0x00007fea24ef10e2: mov    0xa8(%rdx),%rcx
  0x00007fea24ef10e9: mov    %rcx,(%rax)
  0x00007fea24ef10ec: mov    %rdx,%rcx
  0x00007fea24ef10ef: shr    $0x3,%rcx
  0x00007fea24ef10f3: mov    %ecx,0x8(%rax)
  0x00007fea24ef10f6: xor    %rcx,%rcx
  0x00007fea24ef10f9: mov    %ecx,0xc(%rax)
  0x00007fea24ef10fc: xor    %rcx,%rcx          ;*new  ; - com.vs.soutils.Test::<init>@5 (line 5)
                                                ; - com.vs.soutils.Test::<init>@9 (line 5)

  0x00007fea24ef10ff: mov    %rax,%rsi
  0x00007fea24ef1102: mov    $0x7fea22943350,%rdi  ;   {metadata(method data for {method} {0x00007fea229431b0} '<init>' '()V' in 'com/vs/soutils/Test')}
  0x00007fea24ef110c: addq   $0x1,0xa0(%rdi)
  0x00007fea24ef1114: mov    %rax,%rsi          ;*invokespecial <init>
                                                ; - com.vs.soutils.Test::<init>@9 (line 5)
                                                ; - com.vs.soutils.Test::<init>@9 (line 5)

  0x00007fea24ef1117: mov    %rax,0x48(%rsp)
  0x00007fea24ef111c: nop    
  0x00007fea24ef111d: nop    
  0x00007fea24ef111e: nop    
  0x00007fea24ef111f: callq  0x00007fea24e29d60  ; OopMap{[72]=Oop [80]=Oop [88]=Oop off=452}
                                                ;*invokespecial <init>
                                                ; - com.vs.soutils.Test::<init>@9 (line 5)
                                                ; - com.vs.soutils.Test::<init>@9 (line 5)
                                                ;   {optimized virtual_call}
  0x00007fea24ef1124: mov    0x48(%rsp),%rsi
  0x00007fea24ef1129: mov    0x50(%rsp),%rax
  0x00007fea24ef112e: mov    %rsi,%r10
  0x00007fea24ef1131: shr    $0x3,%r10
  0x00007fea24ef1135: mov    %r10d,0xc(%rax)
  0x00007fea24ef1139: mov    %rax,%rsi
  0x00007fea24ef113c: shr    $0x9,%rsi
  0x00007fea24ef1140: mov    $0x7fea20c23000,%rdi
  0x00007fea24ef114a: movb   $0x0,(%rsi,%rdi,1)  ;*putfield test
                                                ; - com.vs.soutils.Test::<init>@12 (line 5)
                                                ; - com.vs.soutils.Test::<init>@9 (line 5)

  0x00007fea24ef114e: mov    0x58(%rsp),%rsi
  0x00007fea24ef1153: mov    %rax,%r10
  0x00007fea24ef1156: shr    $0x3,%r10
  0x00007fea24ef115a: mov    %r10d,0xc(%rsi)
  0x00007fea24ef115e: shr    $0x9,%rsi
  0x00007fea24ef1162: movb   $0x0,(%rsi,%rdi,1)  ;*putfield test
                                                ; - com.vs.soutils.Test::<init>@12 (line 5)

  0x00007fea24ef1166: add    $0x70,%rsp
  0x00007fea24ef116a: pop    %rbp
  0x00007fea24ef116b: test   %eax,0x15e21f8f(%rip)        # 0x00007fea3ad13100
                                                ;   {poll_return}
  0x00007fea24ef1171: retq   
  0x00007fea24ef1172: mov    %rdx,0x8(%rsp)
  0x00007fea24ef1177: movq   $0xffffffffffffffff,(%rsp)
  0x00007fea24ef117f: callq  0x00007fea24ee1d20  ; OopMap{rsi=Oop off=548}
                                                ;*synchronization entry
                                                ; - com.vs.soutils.Test::<init>@-1 (line 3)
                                                ;   {runtime_call}
  0x00007fea24ef1184: jmpq   0x00007fea24ef0fb8
  0x00007fea24ef1189: mov    %rdx,0x8(%rsp)
  0x00007fea24ef118e: movq   $0xffffffffffffffff,(%rsp)
  0x00007fea24ef1196: callq  0x00007fea24ee1d20  ; OopMap{rsi=Oop off=571}
                                                ;*synchronization entry
                                                ; - java.lang.Object::<init>@-1 (line 37)
                                                ; - com.vs.soutils.Test::<init>@1 (line 3)
                                                ;   {runtime_call}
  0x00007fea24ef119b: jmpq   0x00007fea24ef0ff9
  0x00007fea24ef11a0: mov    %rdx,%rdx
  0x00007fea24ef11a3: callq  0x00007fea24edda60  ; OopMap{[88]=Oop off=584}
                                                ;*new  ; - com.vs.soutils.Test::<init>@5 (line 5)
                                                ;   {runtime_call}
  0x00007fea24ef11a8: jmpq   0x00007fea24ef103b
  0x00007fea24ef11ad: mov    %rdx,0x8(%rsp)
  0x00007fea24ef11b2: movq   $0xffffffffffffffff,(%rsp)
  0x00007fea24ef11ba: callq  0x00007fea24ee1d20  ; OopMap{[88]=Oop rax=Oop off=607}
                                                ;*synchronization entry
                                                ; - com.vs.soutils.Test::<init>@-1 (line 3)
                                                ; - com.vs.soutils.Test::<init>@9 (line 5)
                                                ;   {runtime_call}
  0x00007fea24ef11bf: jmpq   0x00007fea24ef107c
  0x00007fea24ef11c4: mov    %rdx,0x8(%rsp)
  0x00007fea24ef11c9: movq   $0xffffffffffffffff,(%rsp)
  0x00007fea24ef11d1: callq  0x00007fea24ee1d20  ; OopMap{[88]=Oop rax=Oop off=630}
                                                ;*synchronization entry
                                                ; - java.lang.Object::<init>@-1 (line 37)
                                                ; - com.vs.soutils.Test::<init>@1 (line 3)
                                                ; - com.vs.soutils.Test::<init>@9 (line 5)
                                                ;   {runtime_call}
  0x00007fea24ef11d6: jmpq   0x00007fea24ef10bd
  0x00007fea24ef11db: mov    %rdx,%rdx
  0x00007fea24ef11de: callq  0x00007fea24edda60  ; OopMap{[88]=Oop [80]=Oop off=643}
                                                ;*new  ; - com.vs.soutils.Test::<init>@5 (line 5)
                                                ; - com.vs.soutils.Test::<init>@9 (line 5)
                                                ;   {runtime_call}
  0x00007fea24ef11e3: jmpq   0x00007fea24ef10ff
  0x00007fea24ef11e8: nop    
  0x00007fea24ef11e9: nop    
  0x00007fea24ef11ea: mov    0x288(%r15),%rax
  0x00007fea24ef11f1: mov    $0x0,%r10
  0x00007fea24ef11fb: mov    %r10,0x288(%r15)
  0x00007fea24ef1202: mov    $0x0,%r10
  0x00007fea24ef120c: mov    %r10,0x290(%r15)
  0x00007fea24ef1213: add    $0x70,%rsp
  0x00007fea24ef1217: pop    %rbp
  0x00007fea24ef1218: jmpq   0x00007fea24edcce0  ;   {runtime_call}
  0x00007fea24ef121d: hlt