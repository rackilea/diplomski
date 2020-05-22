private void updateProperty(com.google.api.services.drive.Drive driveService, String fileId, String email) throws IOException {
    BatchRequest batch = driveService.batch();
    Permission clientPermission = new Permission();
    clientPermission.setEmailAddress(email);
    clientPermission.setRole("writer");
    clientPermission.setType("user");
    driveService.permissions().create(fileId, clientPermission)
            .setFields("id")
            .setSendNotificationEmail(true)
            .queue(batch, new JsonBatchCallback() {
                @Override
                public void onSuccess(Object o, HttpHeaders responseHeaders) throws IOException {
                    Log.e("permissione success", String.valueOf(o));
                    listener.onRecvShareSpreadsheet(true);
                }

                @Override
                public void onFailure(GoogleJsonError e, HttpHeaders responseHeaders) throws IOException {
                    Log.e("permissione error", e.getMessage());
                    listener.onRecvShareSpreadsheet(false);
                }
            });
    batch.execute();
}