fpos_t pos;
char filelocation[256] = "some_place";
int fd = newStdout(filelocation, &pos);
//
//... do some stuff here ...
//... things that put data into stdout ...
//
revertStdout(fd, &pos);