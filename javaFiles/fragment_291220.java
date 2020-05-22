aload_1       ; push local variable 1 (i.e. 'x') onto stack
ldc "hello"   ; push the string "hello" onto stack

; invoke the equals method
invokevirtual java/lang/Object/equals(Ljava/lang/Object;)Z
; the boolean result is now on the stack