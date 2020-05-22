package google;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

import controllers.GlobalUtilities.StringControl;
import play.Configuration;
import play.Logger;

public class GoogleDrive {

    /** Application name. */
    private static final String APPLICATION_NAME = "PTP";

    /** Directory to store user credentials for this application. */
    private static final java.io.File DATA_STORE_DIR = new java.io.File(System.getProperty("user.home"),
            ".credentials/ptpgoogledrive");

    /** Global instance of the {@link FileDataStoreFactory}. */
    private static FileDataStoreFactory DATA_STORE_FACTORY;

    /** Global instance of the JSON factory. */
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    /** Global instance of the HTTP transport. */
    private static HttpTransport HTTP_TRANSPORT;

    /**
     * Global instance of the scopes required by this quickstart.
     *
     * If modifying these scopes, delete your previously saved credentials at
     * ~/.credentials/drive-java-quickstart
     */
    private static final List<String> SCOPES = Arrays.asList(DriveScopes.DRIVE);

    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Creates an authorized Credential object.
     * 
     * @return an authorized Credential object.
     * @throws IOException
     */
    @SuppressWarnings("deprecation")
    public static GoogleCredential authorize() throws IOException {
        GoogleCredential credential = null;
        String credentialsFileName = "";
        try {
            Logger.info("GoogleDrive: authorize: Starting...");

            Logger.info("GoogleDrive: authorize: Getting credentialsFileName path...");
            credentialsFileName = Configuration.root().getString("google.drive.credentials.file");
            Logger.info("GoogleDrive: authorize: credentialsFileName = " + credentialsFileName);

            Logger.info("GoogleDrive: authorize: Setting InputStream...");
            InputStream in = GoogleDrive.class.getClassLoader().getResourceAsStream(credentialsFileName);
            if (in == null) {
                Logger.info("GoogleDrive: authorize: InputStream is null");
            }
            Logger.info("GoogleDrive: authorize: InputStream set...");

            Logger.info("GoogleDrive: authorize: Setting credential...");
            credential = GoogleCredential.fromStream(in, HTTP_TRANSPORT, JSON_FACTORY)
                    .createScoped(Collections.singleton(DriveScopes.DRIVE));
        } catch (IOException ex) {
            System.out.println(ex.toString());
            System.out.println("Could not find file " + credentialsFileName);
            ex.printStackTrace();
        }
        Logger.info("GoogleDrive: authorize: Ending...");
        return credential;
    }

    /**
     * Build and return an authorized Drive client service.
     * 
     * @return an authorized Drive client service
     * @throws IOException
     */
    public static Drive getDriveService() throws IOException {
        Logger.info("GoogleDrive: getDriveService: Starting...");
        GoogleCredential credential = null;
        Drive googleDrive = null;
        try {
            credential = authorize();
            Logger.info("GoogleDrive: getDriveService: Credentials set...");
            googleDrive = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                    .setApplicationName(APPLICATION_NAME).build();
        } catch (IOException ex) {
            System.out.println(ex.toString());
            ex.printStackTrace();
        }
        return googleDrive;
    }

    public static String getPath() {
        String s = GoogleDrive.class.getName();
        int i = s.lastIndexOf(".");
        if (i > -1)
            s = s.substring(i + 1);
        s = s + ".class";
        System.out.println("Class Name: " + s);
        Object testPath = GoogleDrive.class.getResource(s);
        System.out.println("Current Path: " + testPath);
        return "";
    }

    public static String uploadFile(java.io.File file, String folderIDToFind) throws IOException {
        String fileID = "";
        String fileName = "";
        try {
            Logger.info("GoogleDrive: uploadFile: Starting File Upload...");
            // Build a new authorized API client service.
            Drive service = getDriveService();
            Logger.info("GoogleDrive: uploadFile: Completed Drive Service...");

            // Set the folder...
            String folderID = Configuration.root().getString("google.drive.folderid");
            Logger.info("GoogleDrive: uploadFile: Folder ID = " + folderID);

            String folderIDToUse = getSubfolderID(service, folderID, folderIDToFind);

            String fullFilePath = file.getAbsolutePath();
            Logger.info("GoogleDrive: uploadFile: Full File Path: " + fullFilePath);
            File fileMetadata = new File();

            // Let's see what slashes exist to get the correct file name...
            if (fullFilePath.contains("/")) {
                fileName = StringControl.rightBack(fullFilePath, "/");
            } else {
                fileName = StringControl.rightBack(fullFilePath, "\\");
            }
            String fileContentType = getContentType(fileName);
            Logger.info("GoogleDrive: uploadFile: File Content Type: " + fileContentType);
            fileMetadata.setName(fileName);
            Logger.info("GoogleDrive: uploadFile: File Name = " + fileName);

            Logger.info("GoogleDrive: uploadFile: Setting the folder...");
            fileMetadata.setParents(Collections.singletonList(folderIDToUse));
            Logger.info("GoogleDrive: uploadFile: Folder set...");

            // Team Drive settings...
            fileMetadata.set("supportsTeamDrives", true);

            java.io.File filePath = new java.io.File(fullFilePath);

            FileContent mediaContent = new FileContent(fileContentType, filePath);

            File fileToUpload = service.files().create(fileMetadata, mediaContent).setSupportsTeamDrives(true)
                    .setFields("id, parents").execute();

            fileID = fileToUpload.getId();
            Logger.info("GoogleDrive: uploadFile: File ID: " + fileID);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            ex.printStackTrace();
        }
        Logger.info("GoogleDrive: uploadFile: Ending File Upload...");
        return fileID;
    }

    public static String getContentType(String filePath) throws Exception {
        String type = "";
        try {
            Path path = Paths.get(filePath);
            type = Files.probeContentType(path);
            System.out.println(type);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            ex.printStackTrace();
        }
        return type;
    }

    public static String getSubfolderID(Drive service, String parentFolderID, String folderKeyToGet) {
        // We need to see if the folder exists based on the ID...
        String folderID = "";
        Boolean foundFolder = false;
        FileList result = null;
        File newFolder = null;

        // Set the drive query...
        String driveQuery = "mimeType='application/vnd.google-apps.folder' and '" + parentFolderID
                + "' in parents and name contains '" + folderKeyToGet + "' and trashed=false";

        try {
            result = service.files().list().setQ(driveQuery).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (File folder : result.getFiles()) {
            System.out.printf("Found folder: %s (%s)\n", folder.getName(), folder.getId());
            foundFolder = true;
            folderID = folder.getId();
        }
        if (foundFolder != true) {
            // Need to create the folder...
            File fileMetadata = new File();
            fileMetadata.setName(folderKeyToGet);
            fileMetadata.setTeamDriveId(parentFolderID);
            fileMetadata.set("supportsTeamDrives", true);
            fileMetadata.setMimeType("application/vnd.google-apps.folder");
            fileMetadata.setParents(Collections.singletonList(parentFolderID));

            try {
                newFolder = service.files().create(fileMetadata).setSupportsTeamDrives(true).setFields("id, parents")
                        .execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // Send back the folder ID...
            folderID = newFolder.getId();
            System.out.println("Folder ID: " + newFolder.getId());
        }

        return folderID;
    }


}