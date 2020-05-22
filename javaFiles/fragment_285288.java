0.31%  ↗  ...70: movzbl 0x94(%r9),%r10d    
  0.19%  │  ...78: mov    0x108(%r15),%r11  ; read the thread-local page addr
 25.62%  │  ...7f: add    $0x1,%rbp          
 35.10%  │  ...83: test   %eax,(%r11)       ; thread-local handshake poll
 34.91%  │  ...86: test   %r10d,%r10d
         ╰  ...89: je     ...70