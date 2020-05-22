private static void uploadFile(InputStream is) {

            com.google.api.services.drive.model.File fileMetadata = new com.google.api.services.drive.model.File();
            fileMetadata.setTitle(curDateWithFormat()+"-"+fileName);
            fileMetadata.setMimeType("application/pdf");


             HttpTransport httpTransport = new NetHttpTransport();
             JsonFactory jsonFactory = new JacksonFactory();
             AppIdentityCredential credential = new AppIdentityCredential.Builder(Arrays.asList(DriveScopes.DRIVE)).build();
             // API_KEY is from the Google Console as a server API key
             GoogleClientRequestInitializer keyInitializer = new CommonGoogleClientRequestInitializer("AIzaSyCKLTs_D2zYJepjno8OSVy-2CItYayvu0M");
             Drive service = new Drive.Builder(httpTransport, jsonFactory, null)

                 .setApplicationName("TimesheetPDFParser")
                 .setHttpRequestInitializer(credential)
                 .setGoogleClientRequestInitializer(keyInitializer)
                 .build();

             try {
                Drive.Files.Insert in= service.files().insert(fileMetadata, new InputStreamContent("application/pdf",is));
                com.google.api.services.drive.model.File retFile =in.execute();

                if(retFile!=null){
                    Permission newPermission = new Permission();
                    newPermission.setValue("here your email id @gmail.com");
                    newPermission.setType("user");
                    newPermission.setRole("reader");//owner and writer role throws 400 BAD_REQUEST exception    
                    service.permissions().insert(retFile.getId(), newPermission).execute();

                    System.out.println("Drive retFile:"+retFile.getId());   
                }
            } catch (IOException e) {
                System.out.println("Drive Error:"+e.toString());
            }
          }