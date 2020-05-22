private static long client_data(byte datacenter, short client_id, byte data_id, int data_counter)
{
    return (((long) datacenter) << 56) |
           (((long) client_id) << 40) |
           (((long) data_id) << 32) |
            ((long) data_counter);
}