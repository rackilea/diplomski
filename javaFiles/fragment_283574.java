lSql.append("SELECT ");
lSql.append("   TABLE_NAME.ROW_NUMBER() OVER (ORDER BY COLUMN_DAY) as RRN ");
lSql.append("FROM ...")
.
.
.
lClassModel.setColumnSequence(rset.getInt("RRN"));