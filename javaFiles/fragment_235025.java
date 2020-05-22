void clear() {
    for (int i = 0; i!=256 ; i++) {
        op_stack[i] = NULL;
        arg_stack[i] = NULL;
        token[i] = NULL;
    }
    op_sptr = 0;
    arg_sptr = 0;
    parens = 0;
    state = 0;
}