public class UploadFile {

    public static void main(String[] args) {
        String accesstoken ="abc";
        Vimeo vimeo = new Vimeo(accesstoken);
        boolean upgradeTo1080 = true;
        try {
            String videoEndPoint = vimeo.addVideo(new File(pathtoyourvideo), upgradeTo1080);
            System.out.println(videoEndPoint);
        } catch (IOException | VimeoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}