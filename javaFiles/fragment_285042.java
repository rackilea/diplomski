0x0000023d12ec4b14: add     eax,ecx
0x0000023d12ec4b16: inc     ebx

0x0000023d12ec4b18: cmp     ebx,989680h
0x0000023d12ec4b1e: jnl     23d12ec4b4eh ; jump if `ebx` was not less than `10_000_000`

0x0000023d12ec4b20: mov     ecx,dword ptr [r9+rbx*4+10h]

0x0000023d12ec4b25: test    ecx,ecx
0x0000023d12ec4b27: jnl     23d12ec4b14h ; jump if `ecx` was not less-than `0`

0x0000023d12ec4b29: neg     ecx

0x0000023d12ec4b2b: test    ecx,ecx
0x0000023d12ec4b2d: jnl     23d12ec4b14h ; jump if `ecx` was not less-than `0`