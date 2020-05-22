sqlStr.append("INSERT INTO DS_GOAL ")
    .append("(DS_SITE_CODE, DS_FINANCIAL_YEAR, DS_DEPARTMENT_CODE, DS_PLAN_ID, DS_GOAL_ID, ")
    .append("DS_DESC, DS_PLAN_END_DATE, ")
    .append("DS_CORP_OBJECTIVE, DS_CORP_OBJECTIVE_OTHER, DS_FOCUS, DS_FOCUS_OTHER, ")
    .append("DS_TOTAL, DS_EQUIPMENT, DS_RECRUIT, DS_FTE, ")
    .append("DS_CREATED_USER, DS_MODIFIED_USER, DS_GOAL_ORDER ) ")
    .append("VALUES ")
    .append("(?, ?, ?, ?, ?,")
    .append("?, TO_DATE(?, 'dd/MM/YY'),")
    .append("?, ?, ?, ?,")
    .append("?, ?, ?, ?,")
    .append("?, ?, ?)");
    sqlStr_insertGoal = sqlStr.toString();