public static void main(final String[] args) throws Exception
{
    final EnvironmentConfig environmentConfig = new EnvironmentConfig();
    //setup EnvironmentConfig

    final DatabaseConfig primaryConfig = new DatabaseConfig();
    //setup DatabaseConfig

    final SecondaryConfig secondaryConfig = new SecondaryConfig();
    //setup SecondaryConfig if necessary

    final Database primary = environment.openDatabase(null,
            pathToDb, null, primaryConfig);

    final DatabaseEntry key = new DatabaseEntry(new byte[ONE_KIBIBYTE]);
    final DatabaseEntry value = new DatabaseEntry(new byte[ONE_MEBIBYTE]);

    final Cursor cursor = primary.openCursor(null, null);

    OperationStatus status = cursor.getFirst(key, value, null);
    int count = 0;
    while (status.equals(OperationStatus.SUCCESS))
    {
        ++count;
        int readId = -1;
        int size = -1;
        try
        {
            final TupleInput input = new TupleInput(value.getData(), value
                    .getOffset(), value.getSize());
            size = value.getSize();
            readId = input.readInt();

            //read other fields from 'input' local variable

            if (status.equals(OperationStatus.SUCCESS))
            {
                status = cursor.getNext(key, value, null);
            }
        }
        catch (final Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}