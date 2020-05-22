void delete_char(char ch, char buf[], int len) {
        int from, to;
        for (from=0,to=0; from<len; ++from)
                if (buf[from] != ch)
                        buf[to++] = buf[from];
}


_delete_char:
        pushl   %ebp
        movl    %esp, %ebp
        subl    $40, %esp
        movl    8(%ebp), %eax
        movb    %al, -28(%ebp)
        movl    $0, -12(%ebp)
        movl    $0, -16(%ebp)
        jmp     L2
L3:
        movl    -12(%ebp), %eax
        addl    12(%ebp), %eax
        movb    (%eax), %al
        cmpb    -28(%ebp), %al
        je      L4
        movl    -16(%ebp), %eax
        movl    %eax, %edx
        addl    12(%ebp), %edx
        movl    -12(%ebp), %eax
        addl    12(%ebp), %eax
        movb    (%eax), %al
        movb    %al, (%edx)
        incl    -16(%ebp)
L4:
        incl    -12(%ebp)
L2:
        movl    -12(%ebp), %eax
        cmpl    16(%ebp), %eax
        jl      L3
        leave
        ret