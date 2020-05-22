Throwable thrown = null; 
try {   
    //Do very important work here
} catch (ImportantException e) {
    thrown = e;
    throw e;
} finally {   
    if (thrown != null) {
        //We arrived in the finally block due to an exception
    }
}