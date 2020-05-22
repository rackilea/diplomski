L0                     ; on entry stack is empty
  LINENUMBER 6 L0
  GETSTATIC show_cise_image.flag : boolean ; pushes a value, stack height is 1
  LDC 1                                    ; pushes a value, stack heighe is 2  
  PUTSTATIC show_cise_image.flag : boolean ; pop 1 value, stack height is 1
  GOTO L1           ; stack height 1 on going to L1...

L1                  ; stack height 1 from previous goto
  GETSTATIC show_cise_image.flag : boolean ; pushes a value, stack height is 2
  IFNE L2           ; pops 1 value for test, stack height 1 on branch

L2                  ; stack height 1 from previous branch
  GETSTATIC show_cise_image.flag : boolean ; pushes a value, stack height is 2
  LDC 0                                    ; pushes a value, stack height is 3
  PUTSTATIC show_cise_image.flag : boolean ; pops a value, stack height is 2
  ; fall through to L1 with stack height 2