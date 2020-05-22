if (dataModelList.size() > 10000) {
            List<List<BaseDataModel>> baseDataModels = Lists.partition(dataModelList, 5000);
            baseDataModels.stream().forEach(baseModels -> {
                BulkRequest bulkRequest = new BulkRequest();
                baseModels.stream().forEach(baseModel -> {
                    bulkRequest.add(getBaseDataModelIndexRequest(baseModel));
                });
                saveAll(bulkRequest, rawEventIndex);
            });
        }