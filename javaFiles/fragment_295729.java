C:\....>c:\jdk1.7.0_79\bin\java -version
java version "1.7.0_79"
Java(TM) SE Runtime Environment (build 1.7.0_79-b15)
Java HotSpot(TM) 64-Bit Server VM (build 24.79-b02, mixed mode)
C:\....>c:\jdk1.7.0_79\bin\java -XX:+UnlockDiagnosticVMOptions -XX:CompileCommand=print,*AndTest.isPowerOfTwoAND -XX:PrintAssemblyOptions=intel AndTestMain
  .....
  0x0000000002512bac: xor    r10d,r10d
  0x0000000002512baf: mov    r11d,0x1
  0x0000000002512bb5: test   r8,r8
  0x0000000002512bb8: jle    0x0000000002512bde  ;*ifle
  0x0000000002512bba: mov    eax,0x1            ;*lload_1
  0x0000000002512bbf: mov    r9,r8
  0x0000000002512bc2: dec    r9
  0x0000000002512bc5: and    r9,r8
  0x0000000002512bc8: test   r9,r9
  0x0000000002512bcb: cmovne r11d,r10d
  0x0000000002512bcf: and    eax,r11d           ;*iand
  0x0000000002512bd2: add    rsp,0x10
  0x0000000002512bd6: pop    rbp
  0x0000000002512bd7: test   DWORD PTR [rip+0xffffffffffc0d423],eax        # 0x0000000002120000
  0x0000000002512bdd: ret    
  0x0000000002512bde: xor    eax,eax
  0x0000000002512be0: jmp    0x0000000002512bbf
  .....