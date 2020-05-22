0xb1e444b0: fld1
0xb1e444b2: jmp    0xb1e444dd         ;*iload
                                      ; - fptest::calc@9 (line 6)
0xb1e444b7: nop
0xb1e444b8: fldt   0xb523a2c8         ;   {external_word}
0xb1e444be: fmulp  %st,%st(1)
0xb1e444c0: fmull  0xb1e44490         ;   {section_word}
0xb1e444c6: fldt   0xb523a2bc         ;   {external_word}
0xb1e444cc: fmulp  %st,%st(1)
0xb1e444ce: fstpl  0x10(%esp)
0xb1e444d2: inc    %esi               ; OopMap{off=51}
                                      ;*goto
                                      ; - fptest::calc@22 (line 6)
0xb1e444d3: test   %eax,0xb3f8d100    ;   {poll}
0xb1e444d9: fldl   0x10(%esp)         ;*goto
                                      ; - fptest::calc@22 (line 6)
0xb1e444dd: cmp    %ecx,%esi
0xb1e444df: jl     0xb1e444b8         ;*if_icmpge
                                      ; - fptest::calc@12 (line 6)