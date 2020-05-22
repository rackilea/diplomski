InputStream in = null;
        FileOutputStream fos = null;
        try {
            HttpServletRequestWrapper wrappedRequest = new HttpServletRequestWrapper(req);
            InputStream is = wrappedRequest.getInputStream();
            StringWriter writer = new StringWriter();
            IOUtils.copy(is, writer, "UTF-8");
            String imageString = writer.toString();
            imageString = imageString.substring("data:image/png;base64,"
                    .length());
            byte[] contentData = imageString.getBytes();
            byte[] decodedData = Base64.decodeBase64(contentData);
            String imgName = ReloadableProps
                    .getProperty("local.image.save.path")
                    + String.valueOf(System.currentTimeMillis()) + ".png";
            fos = new FileOutputStream(imgName);
            fos.write(decodedData);
        } catch (Exception e) {
            e.printStackTrace();
            String loggerMessage = "Upload image failed : ";
            CVAException.printException(loggerMessage + e.getMessage());
        } finally {
            if (in != null) {
                in.close();
            }
            if (fos != null) {
                fos.close();
            }
        }