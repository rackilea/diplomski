familyLegacy.getParents().stream().collect(
    Collectors.toMap(
        p -> p.getId(),
        p -> p.getChildList().stream().collect(
            Collectors.toMap(
                c -> c.getId(),
                c -> c.getGrandChildList().stream().collect(
                    Collectors.toMap(
                        gc -> gc.getId(),
                        Function.identity()))))));