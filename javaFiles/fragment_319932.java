private static void createRandomInteger(int aStart, long aEnd, Random aRandom){
    if ( aStart > aEnd ) {
      throw new IllegalArgumentException("Start cannot exceed End.");
    }
    //get the range, casting to long to avoid overflow problems
    long range = aEnd - (long)aStart + 1;
    logger.info("range>>>>>>>>>>>"+range);
    // compute a fraction of the range, 0 <= frac < range
    long fraction = (long)(range * aRandom.nextDouble());
    logger.info("fraction>>>>>>>>>>>>>>>>>>>>"+fraction);
    long randomNumber =  fraction + (long)aStart;    
    logger.info("Generated : " + randomNumber);

  }