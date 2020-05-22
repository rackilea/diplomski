private final String addCategorySql = "INSERT INTO CATEGORY(TYPE,ICONID)"
        + " VALUES(?,?);"
private final String updateIconSql = "UPDATE ICON SET FLAG=1 WHERE ICONID=? ";

public boolean addNewCategory(Category category) {
    try {
        int updatedRows = 0;
        int insertedRows = jdbcTemplate.update(addCategorySql, category.getType(), category.getIconId());
        if (insertedRows == 1) { //we are updating Icon table only when any category inserted. Otherwise we return false;
            updatedRows = jdbcTemplate.update(updateIconSql, category.getIconId());
            if (updatedRows == 1) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    } catch (Exception e) {
        logger.error("Exception  :  ", e);
        throw e;
    }
}