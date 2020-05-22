class TestService {
    def openCVTest() {
        File picture = new File("D:\\original.jpg");
        File savingDirectory = new File("D:\\");

        ImageService.cropImage(picture, savingDirectory);

        return;
    }
}