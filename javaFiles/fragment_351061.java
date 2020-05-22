if (result != null && result.get() != null) {
            List<HColumn<String, String>> resultCols = result.get().getColumns();
            for (HColumn<String, String> col : resultCols)
            {
               System.out.println(col.getValue());
            }