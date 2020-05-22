; {metadata('com/example/App$$Lambda$1')}
  0x00007f73b51a0100: 752b                jne       7f73b51a012dh
                                                ;*invokeinterface run
                                                ; - java.lang.Thread::run@11 (line 748)

  0x00007f73b51a0102: 458b530c            mov       r10d,dword ptr [r11+0ch]
                                                ;*getfield arg$1
                                                ; - com.example.App$$Lambda$1/1831932724::run@1
                                                ; - java.lang.Thread::run@-1 (line 747)

  0x00007f73b51a0106: 43c744d41402000000  mov       dword ptr [r12+r10*8+14h],2h
                                                ;*putfield c
                                                ; - com.example.App::lambda$main$0@17 (line 18)
                                                ; - com.example.App$$Lambda$1/1831932724::run@4
                                                ; - java.lang.Thread::run@-1 (line 747)
                                                ; implicit exception: dispatches to 0x00007f73b51a01b5
  0x00007f73b51a010f: 43c744d40c01000000  mov       dword ptr [r12+r10*8+0ch],1h
                                                ;*putfield a
                                                ; - com.example.App::lambda$main$0@2 (line 14)
                                                ; - com.example.App$$Lambda$1/1831932724::run@4
                                                ; - java.lang.Thread::run@-1 (line 747)

  0x00007f73b51a0118: 43c744d41001000000  mov       dword ptr [r12+r10*8+10h],1h
                                                ;*synchronization entry
                                                ; - java.lang.Thread::run@-1 (line 747)

  0x00007f73b51a0121: 4883c420            add       rsp,20h
  0x00007f73b51a0125: 5d                  pop       rbp
  0x00007f73b51a0126: 8505d41eb016        test      dword ptr [7f73cbca2000h],eax
                                                ;   {poll_return}
  0x00007f73b51a012c: c3                  ret
  0x00007f73b51a012d: 4181f885f900f8      cmp       r8d,0f800f985h