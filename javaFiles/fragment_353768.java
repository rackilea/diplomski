// note: this is ipv4 specific, and i haven't tried to compile it.
long ipAsLong = 0;
for (String byteString : ipAddress.split("\\."))
{
    ipAsLong = (ipAsLong << 8) | Integer.parseInt(byteString);
}