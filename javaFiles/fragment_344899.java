loop_begin:
  0x00002aaaabe903d0:  mov    %ecx,%r11d
  0x00002aaaabe903d3:  inc    %r11d             ; i++
  0x00002aaaabe903d6:  cmp    %ebp,%r11d        ; if (i >= n)
  0x00002aaaabe903d9:  jge    0x2aaaabe90413    ;     break;
  0x00002aaaabe903db:  mov    %ecx,%r8d
  0x00002aaaabe903de:  mov    %r11d,%ecx
  0x00002aaaabe903e1:  mov    0x1d0(%r15),%rsi  ; rsi = Thread.current();
  0x00002aaaabe903e8:  mov    0x1d0(%r15),%r10  ; r10 = Thread.current();
  0x00002aaaabe903ef:  cmp    %rsi,%r10         ; if (rsi != r10)
  0x00002aaaabe903f2:  jne    0x2aaaabe903b9    ;     goto slow_path;
  0x00002aaaabe903f4:  mov    0x128(%r15),%r10  ; r10 = current_os_thread();
  0x00002aaaabe903fb:  mov    0x14(%r10),%r11d  ; isInterrupted = r10.interrupt_flag;
  0x00002aaaabe903ff:  test   %r11d,%r11d       ; if (!isInterrupted)
  0x00002aaaabe90402:  je     0x2aaaabe903d0    ;     goto loop_begin