String where = "";

if (from != null && to != null) {
    where += <yourDateCondition>;
}

if (<needToAddSecondCondtion>) {
    if (!where.isEmpty()) {
        where += " and ";
    }
    where += <secondCondition>;
}

// continue with other conditions

String query = "select * from xxxx where " + where;