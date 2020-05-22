try (InputStream is = uploadFile.getInputStream();
        BufferedInputStream buffIs = new BufferedInputStream(is);
        BOMInputStream bomIn = new BOMInputStream(buffIs);) {
      buffIs.mark(LOOKAHEAD_LENGTH);
      // this should allow us to deal with csv's with or without BOMs
      final boolean hasBOM = bomIn.hasBOM();
      final BufferedReader buffReadr = new BufferedReader(
          new InputStreamReader(hasBOM ? bomIn : buffIs, StandardCharsets.UTF_8));

      // if this stream does not have a BOM, then we must reset the stream as the test
      // for a BOM will have consumed some bytes
      if (!hasBOM) {
        buffIs.reset();
      }

      // collect the validated entity details
      final CSVParser parser = CSVParser.parse(buffReadr,
          CSVFormat.DEFAULT.withFirstRecordAsHeader());
      // Do stuff with the parser
      ...
  // Catch and clean up