Cursor cursor = database.rawQuery("select ABSTRACTS_ITEM._id, "
        + "ABSTRACTS_ITEM.TITLE, ABSTRACTS_ITEM.TOPIC, "
        + "ABSTRACTS_ITEM.TYPE, ABSTRACTS_ITEM.TEXT, " // <-- Comma needed
        + "ABSTRACT_KEY_WORDS.KEYWORDS "
        + "from ABSTRACTS_ITEM,ABSTRACT_KEY_WORDS "
        + "where ABSTRACTS_ITEM._id = ABSTRACT_KEY_WORDS._id "
          // Group the OR condition with "()"; AND has higher precedence
        + "and (ABSTRACT_KEY_WORDS.KEYWORDS like '%" + string + "%' "
        + "or ABSTRACTS_ITEM.TITLE like '%" + string + "%')", null);