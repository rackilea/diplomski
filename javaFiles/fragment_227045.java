int parentDocId = -1;
        for (Tuple<IndexReader, IdReaderTypeCache> tuple : readers) {
            IndexReader indexReader = tuple.v1();
            IdReaderTypeCache idReaderTypeCache = tuple.v2();
            if (idReaderTypeCache == null) { // might be if we don't have that doc with that type in this reader
                continue;
            }
            parentDocId = idReaderTypeCache.docById(postingUid);
            if (parentDocId != -1 && !indexReader.isDeleted(parentDocId)) {
                FloatFieldData parentSpringinessFieldData = (FloatFieldData) fieldDataCache.cache(
                        FieldDataType.DefaultTypes.FLOAT,
                        indexReader,
                        "springiness");
                parentSpringiness = parentSpringinessFieldData.value(parentDocId);
                break;
            }
        }
        if (parentDocId == -1) {
            throw new FacetPhaseExecutionException(facetName, "Parent doc " + postingUid + " could not be found!");
        }