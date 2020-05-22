import java.nio.file.Files;
import java.nio.file.Paths;

public class UsableIDs {

    private final static int idsArray[];

    static {
        try {
            String fileData = new String(
                Files.readAllBytes(Paths.get("/temp/usableids.txt")), "UTF-8").trim();
            String[] ids = fileData.split(",");
            idsArray = new int[ids.length];

            for (int i = 0; i < ids.length; i++) {
                idsArray[i] = Integer.parseInt(ids[i]);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String checkID(int x) {
        for (int i = 0; i < idsArray.length; i++) {
            if (x == idsArray[i])
                return "Usable";
        }
        return "NotUsable";
    }
}