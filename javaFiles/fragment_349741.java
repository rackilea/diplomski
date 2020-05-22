int setrlimit(int resource, const struct rlimit *rlim)
{
    struct ctx c = { .res = resource, .rlim = rlim, .err = -1 };
    __synccall(do_setrlimit, &c);
    if (c.err) {
        if (c.err>0) errno = c.err;
        return -1;
    }
    return 0;
}