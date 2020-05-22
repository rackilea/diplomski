if (pageable != null) {

        CouchbaseClient client = operations.getCouchbaseClient();
        View view = client.getView(designDocName(), viewName());

        // Paginator p = new Paginator(client, view, query,
        // pageable.getPageSize());
        Paginator paginator = client.paginatedQuery(view, query, pageable.getPageSize());
        // now we need to goto the start point
        ViewResponse viewResponse = null;
        // views are 0 base
        int i = 0;
        while (paginator.hasNext()) {
            viewResponse = paginator.next();
            if (pageable.getPageNumber() == i++) {
                LOGGER.debug("Found the response for this page: {} ", i);
                break;
            }
        }

        if (viewResponse == null) {
            LOGGER.debug("no view response so leaving now");
            return null;
        }
        Class<?> type = method.getEntityInformation().getJavaType();

        final List result = new ArrayList(viewResponse.size());
        for (final ViewRow row : viewResponse) {
            result.add(operations.findById(row.getId(), type));
        }
        return result;

    }