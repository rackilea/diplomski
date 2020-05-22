StringBuilder sb = new StringBuilder();
    sb.append("INSERT INTO ");
    sb.append(TABLE_NAME);
    sb.append(" SELECT ");
    sb.append(brokers.get(0).getId());
    sb.append(" AS '");
    sb.append(COLUMN_BROKERID);