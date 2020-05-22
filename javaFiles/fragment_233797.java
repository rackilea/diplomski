0x000000000222f570: inc    %ebx               ; OopMap{rbp=Oop off=178}
                                              ;*goto
                                              ; - RemoveJump::testLoop@82 (line 28)
0x000000000222f572: test   %eax,-0x20ff578(%rip)        # 0x0000000000130000
                                              ;*iload
                                              ; - RemoveJump::testLoop@20 (line 28)
                                              ;   {poll}
0x000000000222f578: movslq %ebx,%r10
0x000000000222f57b: cmp    %r14,%r10
0x000000000222f57e: jl     0x000000000222f570