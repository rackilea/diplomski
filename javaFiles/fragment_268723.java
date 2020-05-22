if ( !fromElementsForLoad.contains( origin ) ) {
                        throw new QueryException(
                                "query specified join fetching, but the owner " +
                                "of the fetched association was not present in the select list " +
                                "[" + fromElement.getDisplayText() + "]"
                        );