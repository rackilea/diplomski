public Map<Long, StoreItemDTO> getItems(Long storeId) {

    // Get all item_ids for the store

    SelectHavingStep<Record1<Long>> where = this.ctx
        .select(STORE_ITEM.ID)
        .from(STORE_ITEM)
        .where(STORE_ITEM.STORE_ID.eq(storeId))
        .groupBy(STORE_ITEM.ID);

    // Get all store_item_details according to the fetched item_ids

    TableLike<?> storeItemDetails = this.ctx
        .select(
                STORE_ITEM_DETAILS.ID,
                STORE_ITEM_DETAILS.STORE_ITEM_ID,
                STORE_ITEM_DETAILS.NAME,
                STORE_ITEM_DETAILS.DESCRIPTION,
                STORE_ITEM_DETAILS.STORE_LANGUAGE_ID
                )
        .from(STORE_ITEM_DETAILS)
        .where(STORE_ITEM_DETAILS.STORE_ITEM_ID.in(where))
        .asTable("storeItemDetails");

    // Join the result and use

    final Field<Long> itemIdField = STORE_ITEM.ID.as("item_id");

    Result<?> fetch = fetch = this.ctx
        .select(
                itemIdField,
                storeItemDetails.field(STORE_ITEM_DETAILS.ID),
                storeItemDetails.field(STORE_ITEM_DETAILS.NAME),
                storeItemDetails.field(STORE_ITEM_DETAILS.DESCRIPTION),
                storeItemDetails.field(STORE_ITEM_DETAILS.STORE_LANGUAGE_ID)
                )
        .from(STORE_ITEM)
        .join(storeItemDetails)
        .on(storeItemDetails.field(STORE_ITEM_DETAILS.STORE_ITEM_ID).eq(STORE_ITEM.ID))
        .fetch();

    final Map<Long, StoreItemDTO> itemIdToItemMap = new HashMap<>();

    fetch.intoGroups(
            record -> {
                Long itemDetailsId = record.getValue(STORE_ITEM_DETAILS.ID);
                // ... sake of compactness

                StoreItemDetailsDTO storeItemDetailsDto = new StoreItemDetailsDTO();
                storeItemDetailsDto.setId(itemDetailsId);
                // ... sake of compactness

                Long itemId = record.getValue(itemIdField);

                StoreItemDTO storeItemDto = new StoreItemDTO();
                storeItemDto.setId(itemId);
                storeItemDto.getItemDetailsTranslations().put(languageId, storeItemDetailsDto);

                StoreItemDTO itemDetailsList = itemIdToItemMap.get(itemId);

                if(itemDetailsList == null) {
                    itemDetailsList = new StoreItemDTO();
                    itemIdToItemMap.put(itemId, itemDetailsList);
                }

                itemDetailsList.getItemDetailsTranslations().put(languageId, storeItemDetailsDto);

                return null;
            });

    return itemIdToItemMap;
}