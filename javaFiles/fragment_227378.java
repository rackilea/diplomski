28290 open("...pact/perf/TestDirectIO.class", O_RDONLY|O_DIRECT) = 11
28290 fstat(11, {st_mode=S_IFREG|0644, st_size=2340, ...}) = 0
28290 fcntl(11, F_GETFD)                = 0
28290 fcntl(11, F_SETFD, FD_CLOEXEC)    = 0
...skip
28290 stat("...pact/perf/TestDirectIO.class", {st_mode=S_IFREG|0644, st_size=2340, ...}) = 0
...skip
28290 read(11, "\312\376\272\276\0\0\0003\0\215\n\0-\0D\t\0E\0F\7\0G\n\0\3\0D\10\0H\n"..., 1024) = 1024
28290 read(11, 0x7f1d76d23a00, 1316)    = -1 EINVAL (Invalid argument)