final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try {
        final InputStream inputStream = url.openStream();
        int read;
        while ((read = inputStream.read()) != -1) {
            baos.write(read);
        }

        final Image image = ImagesServiceFactory.makeImage(baos.toByteArray());

        resp.getWriter().println("image width: " + image.getWidth());
        resp.getWriter().println("image height: " + image.getHeight());
    } catch (final IOException e) {
        resp.getWriter().println("image doesn't exists!");
    } catch (final IllegalArgumentException e) {
        resp.getWriter().println("invalid image!");
    }