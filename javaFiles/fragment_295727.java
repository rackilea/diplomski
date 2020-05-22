# {method} {0x0000000017580af0} 'isPowerOfTwoAND' '(J)Z' in 'AndTest'
  # this:     rdx:rdx   = 'AndTest'
  # parm0:    r8:r8     = long
  ...
  0x0000000003103bbe: movabs rax,0x0
  0x0000000003103bc8: cmp    rax,r8
  0x0000000003103bcb: movabs rax,0x175811f0     ;   {metadata(method data for {method} {0x0000000017580af0} 'isPowerOfTwoAND' '(J)Z' in 'AndTest')}
  0x0000000003103bd5: movabs rsi,0x108
  0x0000000003103bdf: jge    0x0000000003103bef
  0x0000000003103be5: movabs rsi,0x118
  0x0000000003103bef: mov    rdi,QWORD PTR [rax+rsi*1]
  0x0000000003103bf3: lea    rdi,[rdi+0x1]
  0x0000000003103bf7: mov    QWORD PTR [rax+rsi*1],rdi
  0x0000000003103bfb: jge    0x0000000003103c1b  ;*lcmp
  0x0000000003103c01: movabs rax,0x175811f0     ;   {metadata(method data for {method} {0x0000000017580af0} 'isPowerOfTwoAND' '(J)Z' in 'AndTest')}
  0x0000000003103c0b: inc    DWORD PTR [rax+0x128]
  0x0000000003103c11: mov    eax,0x1
  0x0000000003103c16: jmp    0x0000000003103c20  ;*goto
  0x0000000003103c1b: mov    eax,0x0            ;*lload_1
  0x0000000003103c20: mov    rsi,r8
  0x0000000003103c23: movabs r10,0x1
  0x0000000003103c2d: sub    rsi,r10
  0x0000000003103c30: and    rsi,r8
  0x0000000003103c33: movabs rdi,0x0
  0x0000000003103c3d: cmp    rsi,rdi
  0x0000000003103c40: movabs rsi,0x175811f0     ;   {metadata(method data for {method} {0x0000000017580af0} 'isPowerOfTwoAND' '(J)Z' in 'AndTest')}
  0x0000000003103c4a: movabs rdi,0x140
  0x0000000003103c54: jne    0x0000000003103c64
  0x0000000003103c5a: movabs rdi,0x150
  0x0000000003103c64: mov    rbx,QWORD PTR [rsi+rdi*1]
  0x0000000003103c68: lea    rbx,[rbx+0x1]
  0x0000000003103c6c: mov    QWORD PTR [rsi+rdi*1],rbx
  0x0000000003103c70: jne    0x0000000003103c90  ;*lcmp
  0x0000000003103c76: movabs rsi,0x175811f0     ;   {metadata(method data for {method} {0x0000000017580af0} 'isPowerOfTwoAND' '(J)Z' in 'AndTest')}
  0x0000000003103c80: inc    DWORD PTR [rsi+0x160]
  0x0000000003103c86: mov    esi,0x1
  0x0000000003103c8b: jmp    0x0000000003103c95  ;*goto
  0x0000000003103c90: mov    esi,0x0            ;*iand
  0x0000000003103c95: and    rsi,rax
  0x0000000003103c98: and    esi,0x1
  0x0000000003103c9b: mov    rax,rsi
  0x0000000003103c9e: add    rsp,0x50
  0x0000000003103ca2: pop    rbp
  0x0000000003103ca3: test   DWORD PTR [rip+0xfffffffffe44c457],eax        # 0x0000000001550100
  0x0000000003103ca9: ret