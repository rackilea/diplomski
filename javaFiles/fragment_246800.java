if (sheet instanceof XSSFSheet)
    {
        final CTWorksheet workSheet = ((XSSFSheet) sheet).getCTWorksheet();
        if (workSheet != null)
        {
            final CTSheetViews views = workSheet.getSheetViews();
            if (views != null)
            {
                if (views.getSheetViewArray(0) != null)
                {
                    views.getSheetViewArray(0).setTopLeftCell("A1");
                }
            }
        }
    }