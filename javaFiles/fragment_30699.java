// (...)
      urlConnection.connect();

      // Just in order to check if the property has indeed been set in the aspect
      System.out.println(urlConnection.getRequestProperty("From"));

      OutputStream outputStream = urlConnection.getOutputStream();
// (...)