@Query(
        value = "select c from CategoryEntity c " +
                " WHERE LOWER(c.categoryNameEn) LIKE LOWER(CONCAT('%',?2, '%')) AND activeInd = ?1 " +
                "AND c.categoryByParentCategoryId is null" +
                " Order By c.categoriesByCategoryId.size desc",
        countQuery = "select count(c) from CategoryEntity c " +
                " WHERE LOWER(c.categoryNameEn) LIKE LOWER(CONCAT('%',?2, '%')) AND activeInd = ?1" +
                " AND c.categoryByParentCategoryId is null"
)
Page<CategoryEntity> findAllActiveCategoriesByCategoriesByCategoryIdCountDesc(String activeInd, String categoryNameEn, Pageable pageable);