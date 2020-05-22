mov    0x60(%r15),%rdx        ; obj = currentThread.tlab_top
    mov    %rdx,%r10
    add    $0x10,%r10             ; r10 = obj + sizeof(java/lang/Object)
    cmp    0x70(%r15),%r10        ; if (r10 >= currentThread.tlab_end)
    jae    0x00000000030ad2f4     ;     goto slow_case
    mov    %r10,0x60(%r15)        ; currentThread.tlab_top = r10

    prefetchnta 0xc0(%r10)        ; prefetch memory next to tlab_top into CPU caches
                                  ; to make subsequent allocations faster

    mov    $0x200001e5,%r10d      ; r10 = VMKlass of java/lang/Object
    shl    $0x3,%r10
    mov    0xa8(%r10),%r10        ; r10 = Header prototype for java/lang/Object
    mov    %r10,(%rdx)            ; obj[0] = r10 (header prototype)
    movl   $0x200001e5,0x8(%rdx)  ; obj[8] = VMKlass of java/lang/Object
    mov    %r12d,0xc(%rdx)        ; obj[12] = 0 (padding to 8-byte boundary)