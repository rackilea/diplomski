public interface Creator<T> {
    /**
     * Create a new array of the Parcelable class.
     * 
     * @param size Size of the array.
     * @return Returns an array of the Parcelable class, with every entry
     * initialized to null.
     */
    public T[] newArray(int size);
}