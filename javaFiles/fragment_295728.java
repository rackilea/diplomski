# {method} {0x0000000017580bd0} 'isPowerOfTwoANDAND' '(J)Z' in 'AndTest'
  # this:     rdx:rdx   = 'AndTest'
  # parm0:    r8:r8     = long
  ...
  0x0000000003103438: movabs rax,0x0
  0x0000000003103442: cmp    rax,r8
  0x0000000003103445: jge    0x0000000003103471  ;*lcmp
  0x000000000310344b: mov    rax,r8
  0x000000000310344e: movabs r10,0x1
  0x0000000003103458: sub    rax,r10
  0x000000000310345b: and    rax,r8
  0x000000000310345e: movabs rsi,0x0
  0x0000000003103468: cmp    rax,rsi
  0x000000000310346b: je     0x000000000310347b  ;*lcmp
  0x0000000003103471: mov    eax,0x0
  0x0000000003103476: jmp    0x0000000003103480  ;*ireturn
  0x000000000310347b: mov    eax,0x1            ;*goto
  0x0000000003103480: and    eax,0x1
  0x0000000003103483: add    rsp,0x40
  0x0000000003103487: pop    rbp
  0x0000000003103488: test   DWORD PTR [rip+0xfffffffffe44cc72],eax        # 0x0000000001550100
  0x000000000310348e: ret