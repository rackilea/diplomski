public class JITExample {
  private static MediaFile audioFile;

  public static void main(String... megaThrustersAreGo) {

    //File file = new File("/home/rhigdon/Desktop/project-voltron/test-files/video.mp4");
    //File file = new File("/home/rhigdon/Desktop/project-voltron/test-files/movGetOutTheWay_iPhone_Cellular_1.3gp");
    File file = new File("/home/rhigdon/Desktop/project-voltron/test-files/movGetOutTheWay_HD_WMV_720p_1.wmv");
    //Entagged Soltuion

    audioFile = new MP3File(file);


    try {
      ID3V2_3_0Tag tag = new ID3V2_3_0Tag();
      tag.setArtist("Ryan Higdon");
      tag.setAlbum("Ryan's Funky Beats");
      audioFile.setID3Tag(tag);
      audioFile.sync();
      for (ID3Tag eachTag : audioFile.getTags()) {
        System.out.println(eachTag.toString());
      }

    } catch (ID3Exception e) {
      e.printStackTrace();
      System.out.println("something bad happened");
    }


  }
}