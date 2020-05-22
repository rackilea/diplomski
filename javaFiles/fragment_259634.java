/**
 * Returns the newly created file only if the user entered a valid path.
 * @param path input path where to store the new file
 * @param fileName name of the file to be created in directory path
 * @throws IllegalArgumentException when the input path doesn't exist.  
 */
def createFile(path: File, fileName: String) : File = {
    require(path.exists, s"""Illegal input path "${path.getAbsolutePath()}", it doesn't exist""")
    // now it is safe to create the file ...
    val result = new File(path, fileName)
    // ...
    result
}