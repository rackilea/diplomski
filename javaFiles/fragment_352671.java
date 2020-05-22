private void getJsonContent() {
    try (ZipInputStream zin = new ZipInputStream(new BufferedInputStream(
            new FileInputStream(backupFile)))) {
        ZipEntry entry;
        while ((entry = zin.getNextEntry()) != null) {
            if (entry.getName().equalsIgnoreCase("content.json")) {
                long size = entry.getSize();
                if (size > 100_000) {
                    throw new IllegalArgumentException("Data too large");
                }
                // We could use an InputStreamReader and read text piecewise.
                // However JSON parsing also is easiest on an entire text.
                byte[] buffer = new byte[(int)size];
                int n = zin.readFully(buffer, 0, buffer.length);
                String json = new String(buffer, StandardCharsets.UTF_8);
                JSONObject obj = new JSONObject(json);
                logger.info(json);

                // Assign "global" Values to Variables
                this.createdAt = obj.getString("created_at");
                this.version = obj.getString("version");

                // Fill table if applicable                     
                for (int i = 0; i < obj.getJSONArray("content").length(); i++) {
                    JSONObject sub = obj.getJSONArray("content").getJSONObject(i);
                    logger.info(sub);

                    infoTable.addItem(new Object[] {
                            sub.get("imported_identities").toString(),
                            sub.get("project_versions").toString(),
                            sub.get("last_import").toString(),
                            sub.get("client").toString(),
                            sub.get("project").toString()
                    }, i + 1);
                }
            } // if
            zin.closeEntry(); // Do not forget preparing for the next entry
        }
    } catch (IOException e) {
        logger.info("Can't read File.");
    } catch (JSONException jse) {
        logger.info("JSON Content could not be read: " + jse.getMessage());
    }
}