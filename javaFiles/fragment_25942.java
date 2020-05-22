children.stream().collect(
    Collectors.groupingBy(
        gc -> gc.getChild().getParent().getFamilyLegacy().getId(),
        Collectors.groupingBy(
            gc -> gc.getChild().getParent().getId(),
            Collectors.groupingBy(
                gc -> gc.getChild().getId()))));