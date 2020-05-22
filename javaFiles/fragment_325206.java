public class ImageFileInfo implements Serializable {
   // Other class variables
   private byte[] thumbarray;
   private byte[] fullarray;

   // Constructors, Getters/Setters
}

ImageFile.setThumb(rs.getBytes("imagethumb"));
ImageFile.setFull(rs.getBytes("imagefull"));