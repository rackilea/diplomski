import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author blj0011
 */
public class FileDeletion
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        try {
            // path of folder to check
            String extension = "txt";
            String startWith = "test";
            LocalDate beforeDate = LocalDate.parse("2018-06-05");

            String path = "C:/Users/userName/Desktop/test_folder";
            List<Path> paths = Files.list(Paths.get(path)).collect(Collectors.toList());

            for (Path entry : paths) {
                System.out.println("Entry: " + entry);
                BasicFileAttributes attributes = Files.readAttributes(entry, BasicFileAttributes.class);
                System.out.println("\tCreation Time/UTC Time: " + attributes.creationTime());
                Instant instant = Instant.parse(attributes.lastModifiedTime().toString());
                LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneId.of(ZoneOffset.UTC.getId()));
                System.out.println("\tLocal Date: " + ldt.toLocalDate());
                System.out.println("\tBefore Date: " + beforeDate);
                if (entry.getFileName().toString().startsWith(startWith) && entry.getFileName().toString().endsWith(extension) && ldt.toLocalDate().isBefore(beforeDate)) {
                    System.out.println("\tMarked for deletion: Yes");                      
                }
                else {
                    System.out.println("\tMarked for deletion: No");
                }

                System.out.println("\n");
            }
        }
        catch (IOException ex) {
            Logger.getLogger(FileDeletion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}