public class FileMapperDemo {
    public static void main(String[] args) {
        /*
         * 1. For each file in directory
         *    2. Read first 512 bytes into buffer array
         *       3. Create a new CompositeFileExtension object and pass it the buffer
         * 
         */

                     CompositeFileExtension fileExtensions = new CompositeFileExtension();

                     //4. get the file extension 
                     String fileExtension = fileExtensions.getExtension(buffer);

    }
}