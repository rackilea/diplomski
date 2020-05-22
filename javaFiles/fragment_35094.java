ElementSelectors.conditionalBuilder()
    .whenElementIsNamed("LANGUAGE")
    .thenUse(ElementSelectors.byNameAndAllAttributes)
    .whenElementIsNamed("CODE")
    .thenUse(ElementSelectors.byNameAndText)
    .elseUse(ElementSelectors.byName)
    .build();