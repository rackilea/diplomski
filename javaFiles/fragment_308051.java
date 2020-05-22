public List<BaseTableOfContents> searchNodesForText(@Nullable String rootHash,
                                                            @Nullable String substring) {
        List<BaseTableOfContentsNode> returnValue = null;
        if (StringUtils.isNotEmpty(substring) && StringUtils.isNotEmpty(rootHash)) {
            String likeQuery = "%" + substring.indexOf(0) + "%";
            Cursor cursor = mDatabase.query(Tables.TOC_NODES, null,
                                            Columns.TOC_ROOT_NODE_HASH + " = ? AND (" +
                                            Columns.DISPLAY_TEXT + " LIKE ? OR " +
                                            Columns.TOC_IS_TITLE_BREAK + " = 1)",
                                            new String[] { rootHash, likeQuery }, null, null,
                                            Columns.TOC_SORT_ORDER + ORDER_ASCENDING);

            returnValue = getNodesFromCursor(cursor);
            cursor.close();
        }