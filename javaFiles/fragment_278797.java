public class SampleContentProvider extends ContentProvider implements ContentProvider.PipeDataWriter<InputStream> {

    static final UriMatcher uriMatcher;


    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        //Uri matcher for different 

    }

    /**
     * Database specific constant declarations
     */
    private SQLiteDatabase db;


    @Override
    public boolean onCreate() {
        return true;
    }


    @Override
    public Uri insert(Uri uri, ContentValues values) {

        throw new SQLException("Insert operation not supported for  " + uri);
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        //condition just for files. You can try something else
        if (uri.toString().contains("files")) {

            //you get the file name
            String lastSegment = uri.getLastPathSegment();

            if (projection == null) {
                projection = new String[]{OpenableColumns.DISPLAY_NAME, OpenableColumns.SIZE};
            }

            File file = //Code to read the file as u have the directory, just get the file from the file name obtained from the uri


            if (null == file) {
                throw new IllegalArgumentException("Unknown File for Uri " + uri);
            }
            String[] cols = new String[projection.length];
            Object[] values = new Object[projection.length];
            int i = 0;
            for (String col : projection) {
                if (OpenableColumns.DISPLAY_NAME.equals(col)) {
                    cols[i] = OpenableColumns.DISPLAY_NAME;
                    values[i++] = //file name;
                } else if (OpenableColumns.SIZE.equals(col)) {
                    cols[i] = OpenableColumns.SIZE;
                    values[i++] = //file size;
                }
            }

            cols = copyOf(cols, i);
            values = copyOf(values, i);

            final MatrixCursor cursor = new MatrixCursor(cols, 1);
            cursor.addRow(values);
            return cursor;
        }

        return super.query(uri, projection, selection, selectionArgs, sortOrder);

    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return super.delete(uri, selection, selectionArgs);

    }


    private static String[] copyOf(String[] original, int newLength) {
        final String[] result = new String[newLength];
        System.arraycopy(original, 0, result, 0, newLength);
        return result;
    }

    private static Object[] copyOf(Object[] original, int newLength) {
        final Object[] result = new Object[newLength];
        System.arraycopy(original, 0, result, 0, newLength);
        return result;
    }

    @Nullable
    @Override
    public ParcelFileDescriptor openFile(Uri uri, String mode) throws FileNotFoundException {

        File file = //read the file
        if (file != null) {
            try {
                StrictMode.ThreadPolicy tp = StrictMode.ThreadPolicy.LAX;
                StrictMode.setThreadPolicy(tp);   
                InputStream in = //Code to get the inputstream;
                // Start a new thread that pipes the stream data back to the caller.
                return openPipeHelper(uri, null, null, in, this);
            } catch (IOException e) {
                FileNotFoundException fnf = new FileNotFoundException("Unable to open " + uri);
                throw fnf;
            }
        }

        throw new IllegalArgumentException("Unknown URI " + uri);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return super.update(uri, values, selection, selectionArgs);
    }

    @Override
    public void writeDataToPipe(ParcelFileDescriptor output, Uri uri, String mimeType,
                                Bundle opts, InputStream args) {
        // Transfer data from the asset to the pipe the client is reading.
        byte[] buffer = new byte[8192];
        int n;
        FileOutputStream fout = new FileOutputStream(output.getFileDescriptor());
        try {
            while ((n = args.read(buffer)) >= 0) {
                fout.write(buffer, 0, n);
            }
        } catch (IOException e) {
        } finally {
            try {
                args.close();
            } catch (IOException e) {
            }
            try {
                fout.close();
            } catch (IOException e) {
            }
        }
    }

}