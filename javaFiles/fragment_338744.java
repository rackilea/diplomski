public interface IProfileImageTask {

    /**
     * indicates that the operation has finished.
     * @param localUri
    **/
    void OnImageAvailable(@NonNull Uri localUri);
}