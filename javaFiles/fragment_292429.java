else {
           errorCount++;
           logger.info("404: Today's file couldn't be found. Using " + getDayBefore(errorCount) + "data.csv");
           /* return */ getJSON("/data/"+ getDayBefore(errorCount)+"data.csv");
           errorCount = 0;
          }