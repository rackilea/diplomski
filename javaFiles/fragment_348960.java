// see 3.
final Date beforeDate = sourceFormat.parse("2001.01.01");

records.getRecordsList().stream()       
    .filter(r -> r.getTrackListing().size() > 10)
    .filter(r - {
       // if the parsedDate is invalid we don't want to process, see 1. and 2.
       Date parsedDate;
       try {
          parsedDate = sourceFormat.parse(r.getReleaseDate());
       } catch (ParseException e) {
          System.err.println("...");
          e.printStackTrace();
          parsedDate = null;
       }

       return parsedDate != null && parsedDate.before(beforeDate);
    })
    .map(r -> {
       // map the records to an release
       Release release = new Release();
       release.setName(r.getName());
       release.setTrackCount(r.getTrackListing().size());
       return release;
    })
    .collect(Collectors.toList()));