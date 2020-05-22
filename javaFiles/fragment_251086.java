/**
 * Flag to indicate that the target file should be appended if it already
 * exists. If this flag is set then the flag
 * {@link #setShouldDeleteIfExists(boolean) shouldDeleteIfExists} is
 * automatically set to false, so that flag should not be set explicitly.
 * Defaults value is false.
 * 
 * @param append the flag value to set
 */
public void setAppendAllowed(boolean append) {
    this.append = append;
    this.shouldDeleteIfExists = false;
}