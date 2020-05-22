0x0000000002d011d0: mov    0x28(%rsp),%r11  <---- the problem is here
0x0000000002d011d5: add    %r10,%r11
0x0000000002d011d8: add    $0x1,%r10
0x0000000002d011dc: add    $0x1,%r11
0x0000000002d011e0: mov    %r11,0x28(%rsp)    ;*ladd
                                              ; - TestPerformanceOfStaticVsDynamicCalls::addStatic@2
                                              ; - TestPerformanceOfStaticVsDynamicCalls::run@33

0x0000000002d011e5: mov    0x28(%rsp),%r11  <---- the problem is here
0x0000000002d011ea: add    $0x1,%r11          ; OopMap{[32]=Oop off=526}
                                              ;*goto
                                              ; - TestPerformanceOfStaticVsDynamicCalls::run@44

0x0000000002d011ee: test   %eax,-0x1c911f4(%rip)        # 0x0000000001070000
                                              ;*goto
                                              ; - TestPerformanceOfStaticVsDynamicCalls::run@44
                                              ;   {poll}
0x0000000002d011f4: cmp    $0x3b9aca00,%r10
0x0000000002d011fb: jl     0x0000000002d011d0  ;*ifge
                                              ; - TestPerformanceOfStaticVsDynamicCalls::run@25