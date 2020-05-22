0x0000000002672580: sub    $0x18,%rsp
0x0000000002672587: mov    %rbp,0x10(%rsp)    ;*synchronization entry
0x000000000267258c: mov    %edx,%eax
0x000000000267258e: add    $0x10,%rsp
0x0000000002672592: pop    %rbp
0x0000000002672593: test   %eax,-0x2542599(%rip)        # 0x0000000000130000
                                                ;   {poll_return}
0x00000000025b2599: retq