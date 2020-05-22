/**
 * Open DB somehow
 */
db.beginTransaction();
try {
     /**
      * Select your N records from DB
      */

     /**
      * Perform any other action and Delete from DB
      */
} catch {
     /**
      * Handle Exception and Do Rollback
      */
} finally {
    db.endTransaction();
}