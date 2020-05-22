int ret=0;
int offset=0;
int BUFF_LEN=64*1024;
byte[] buffer = new byte[BUFF_LEN];
while ((ret = is.read(buffer, offset, BUFF_LEN - offset)) > 0)
{
    offset+=ret;
    // just in case the file is bigger that the buffer size
   if (offset >= BUFF_LEN) break;
}