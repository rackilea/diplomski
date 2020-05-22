0x000001d89e8a4b20: mov     ecx,dword ptr [r9+rdi*4+10h]

0x000001d89e8a4b25: cmp     ecx,80000000h
0x000001d89e8a4b2b: je      1d89e8a4b66h ; jump if `ecx` was equal to `2147483648`

0x000001d89e8a4b2d: mov     r11d,ecx
0x000001d89e8a4b30: neg     r11d
0x000001d89e8a4b33: test    ecx,ecx
0x000001d89e8a4b35: cmovl   ecx,r11d

0x000001d89e8a4b39: add     eax,ecx
0x000001d89e8a4b3b: inc     edi

0x000001d89e8a4b3d: cmp     edi,989680h
0x000001d89e8a4b43: jl      1d89e8a4b20h ; jump if `edi` was less than `10_000_000`