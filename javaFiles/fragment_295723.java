# {method} {0x00000000170a0810} 'AndSC' '(III)Z' in 'AndTest'
  ...
  0x0000000002c26e2c: cmp    r9d,r8d
  0x0000000002c26e2f: jl     0x0000000002c26e36  ;*if_icmplt
  0x0000000002c26e31: cmp    r9d,edi
  0x0000000002c26e34: jle    0x0000000002c26e44  ;*iconst_0
  0x0000000002c26e36: xor    eax,eax            ;*synchronization entry
  0x0000000002c26e38: add    rsp,0x10
  0x0000000002c26e3c: pop    rbp
  0x0000000002c26e3d: test   DWORD PTR [rip+0xffffffffffce91bd],eax        # 0x0000000002910000
  0x0000000002c26e43: ret    
  0x0000000002c26e44: mov    eax,0x1
  0x0000000002c26e49: jmp    0x0000000002c26e38