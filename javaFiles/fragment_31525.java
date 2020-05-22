DbDataSource dataSource = ...;
dataSource.getModel().traverser().forEach(dasObject ->
    {
        if (dasObject instanceof DasTable) {
        }
        else if (dasObject instanceof DasColumn) {
        }
        else if (dasObject instanceof DasIndex) {
        }
        else if (dasObject instanceof DasConstraint) {
        }
        else if (dasObject instanceof DasRoutine) {
        }
    });