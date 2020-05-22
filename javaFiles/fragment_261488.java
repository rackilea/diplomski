int printf(const char* fmt, ...) {
  va_list argp;

  va_start(argp, fmt); // usually something like: argp = (char *)&fmt - sizeof(void *);

  int arg1 = va_arg(argp, int); // *(int *)argp; argp += sizeof(int);
  void *arg2 = va_arg(argp, void*); // *(void **)argp; argp += sizeof(void *);
  float arg3 = va_arg(argp, float); // *(float *)argp; argp += sizeof(float);

  va_end(argp); // no-op

}