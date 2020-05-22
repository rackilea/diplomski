public static int socket_read(DataInputStream dis, int arr[], int off, int len)
{
    b = new byte[len];
    int rv = dis.read(b, off, len);
    for(int i=0; i < len; i++)
    {
        arr[i] = ((int)b[i]) & 0xFF;
    }
    return rv;
}