cursor = this.getReadableDatabase().rawQuery(
        String.format(
                "SELECT a.%s %s, question_id, a.text text, is_correct " +
                        "FROM %s a JOIN %s q ON a.question_id = q.%s",
                BaseColumns._ID, BaseColumns._ID,
                ANSWERS_TABLE_NAME, QUESTIONS_TABLE_NAME, BaseColumns._ID
        ), null);