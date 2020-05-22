package Sound;
public class ResourceTest {
    public static void main(String[] args) {
        String fileName = "Kalimba.mp3";
        System.out.println(fileName);
        System.out.println(new ResourceTest().getClass().getResource(fileName));
        System.out.println(new ResourceTest().getClass().getClassLoader().getResource(fileName));