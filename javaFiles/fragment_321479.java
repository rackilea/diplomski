protected void stopDevAppServer() throws MojoExecutionException {
    HttpURLConnection connection = null;
    try {
      Integer port = firstNonNull(this.port, 8080);
      URL url = new URL("http", firstNonNull(address, "localhost"), port, "/_ah/admin/quit");
      connection = (HttpURLConnection) url.openConnection();
      connection.setDoOutput(true);
      connection.setDoInput(true);
      connection.setRequestMethod("POST");
      connection.getOutputStream().write(0); // <-- Problem is here!
      ByteStreams.toByteArray(connection.getInputStream());
      connection.disconnect();
      getLog().warn("Shutting down devappserver on port " + port);
      Thread.sleep(2000);
    } catch (MalformedURLException e) {
      throw new MojoExecutionException("URL malformed attempting to stop the devserver : " + e.getMessage());
    } catch (IOException e) {
      getLog().debug("Was not able to contact the devappserver to shut it down.  Most likely this is due to it simply not running anymore. ", e);
    } catch (InterruptedException e) {
      Throwables.propagate(e);
    }
  }