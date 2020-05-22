for (IElement element : list) {
        if (element instanceof IBlockElement) {
            if (!element.hasProperty(10001)) {
                document.add((IBlockElement) element);
            } else {
                document.add(new AreaBreak(new PageSize(PageSize.A4).rotate()));
                document.add((IBlockElement) element);
                document.getPdfDocument().setDefaultPageSize(PageSize.A4);
            }
        }
    }