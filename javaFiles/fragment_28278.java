@Nullable
@Override
public ParcelFileDescriptor openFile(@NonNull Uri uri, @NonNull String mode) throws FileNotFoundException {
    ParcelFileDescriptor[] pipe = null;
    try {
        pipe = ParcelFileDescriptor.createReliablePipe();
    } catch (IOException e) {
        Log.d(TAG, "Error creating pipe", e);
    }
    if (mode.contains("r")) {
        FileInputStream fis = FileEncryptionWrapper.getEncryptedFileInputStream(getContext(), uri);
        new PipeFeederThread(fis, new ParcelFileDescriptor.AutoCloseOutputStream(pipe[1])).start();
        return pipe[0];
    } else if (mode.contains("w")) {
        FileOutputStream fos = FileEncryptionWrapper.getEncryptedFileOutputStream(getContext(), uri);
        new PipeFeederThread(new ParcelFileDescriptor.AutoCloseInputStream(pipe[0]), fos).start();
        return pipe[1];
    }
    return null;
}