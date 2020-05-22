public class CameraTest {

    @Rule
    public CameraRule rule = new CameraRule();

    @Test
    @EnableCamera
    public void testWithCamera() {
        Assert.assertTrue(CameraHolder.CAMERA);
    }

    @Test
    public void testWithoutCamera() {
        Assert.assertFalse(CameraHolder.CAMERA);
    }

}