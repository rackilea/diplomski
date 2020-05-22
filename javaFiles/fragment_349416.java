;; NASM/FASM syntax
;; GetQuadrant(int x, int y)
;; RETURN [1|2|3|4] in EAX register
GetQuadrant:
    MOV     eax, [esp+4] ;; = x
    MOV     ecx, [esp+8] ;; = y
    SHR     eax, 31 ;; = >> 31
    SHR     ecx, 31 ;; = >> 31 
    XOR     eax, ecx ;; = x XOR y
    LEA     eax, [eax + ecx * 2 + 1] ;; = x + y*2 + 1
    RET     8 ;; correct stack and return