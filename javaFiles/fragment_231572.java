int newStdout(const char *filename, fpos_t *pos)
{
  fflush(stdout);
  fgetpos(stdout, pos);
  int fd = dup(fileno(stdout));
  freopen(filename, "w", stdout);
  return fd;
}

void revertStdout(int fd, fpos_t *pos)
{
  fflush(stdout);
  dup2(fd, fileno(stdout));
  close(fd);
  clearerr(stdout);
  fsetpos(stdout, pos);
}