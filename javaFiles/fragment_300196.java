@Query("SELECT  e.emails_count AS emailcount, c.* " +
        "FROM contacts_table c " +
        "INNER JOIN ( " +
        "   SELECT email_to, COUNT(email_to) emails_count " +
        "   FROM emails_table " +
        "   GROUP BY email_to) e " +
        "ON e.email_to = c.email_to")
List<ContactWithEmailCounts> testit();