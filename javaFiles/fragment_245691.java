0x0000000002d01054: add    %rbx,%r14
0x0000000002d01057: add    $0x1,%rbx          ;*ladd
                                              ; - TestPerformanceOfStaticVsDynamicCalls::addDynamic@2
                                              ; - TestPerformanceOfStaticVsDynamicCalls::run@105

0x0000000002d0105b: add    $0x1,%r14          ; OopMap{rbp=Oop off=127}
                                              ;*goto
                                              ; - TestPerformanceOfStaticVsDynamicCalls::run@116

0x0000000002d0105f: test   %eax,-0x1c91065(%rip)        # 0x0000000001070000
                                              ;*lload
                                              ; - TestPerformanceOfStaticVsDynamicCalls::run@92
                                              ;   {poll}
0x0000000002d01065: cmp    $0x3b9aca00,%rbx
0x0000000002d0106c: jl     0x0000000002d01054