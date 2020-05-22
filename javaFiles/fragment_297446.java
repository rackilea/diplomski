String query = "SELECT * FROM " + TABLE_QUEST + " WHERE ";
    for (int x = 0; x < nQuestions; x++) {
        if (x > 0) {
            query += " OR ";
        }
        query += "id=" + random.nextInt(5);
    }