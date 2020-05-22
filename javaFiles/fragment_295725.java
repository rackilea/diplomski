# {method} {0x00000000170a0908} 'AndNonSC' '(III)Z' in 'AndTest'
  ...
  0x0000000002c270b5: cmp    r9d,r8d
  0x0000000002c270b8: jl     0x0000000002c270df  ;*if_icmplt
  0x0000000002c270ba: mov    r8d,0x1            ;*iload_2
  0x0000000002c270c0: cmp    r9d,edi
  0x0000000002c270c3: cmovg  r11d,r10d
  0x0000000002c270c7: and    r8d,r11d
  0x0000000002c270ca: test   r8d,r8d
  0x0000000002c270cd: setne  al
  0x0000000002c270d0: movzx  eax,al
  0x0000000002c270d3: add    rsp,0x10
  0x0000000002c270d7: pop    rbp
  0x0000000002c270d8: test   DWORD PTR [rip+0xffffffffffce8f22],eax        # 0x0000000002910000
  0x0000000002c270de: ret    
  0x0000000002c270df: xor    r8d,r8d
  0x0000000002c270e2: jmp    0x0000000002c270c0