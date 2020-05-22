/**
 * Your parsed element may contain single quote ('). 
 * This will cause error while persisting.
 * to avoid this you need to escape single quote (')
 * with double single quote ('')
 */

 if (element.toString().contains("docker")) {
     postFeeds = postFeeds.concat(element.toString().replaceAll("'", "''"));  
     //save postFeeds to DB
 }