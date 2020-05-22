// scan CSS rules including rules contained in media rules 
void scanRules(CSSRuleList rules, Predicate<String> classNameTest,
        BiConsumer<Set<String>, CSSStyleRule> ruleAction) {
    for (int ri = 0; ri < rules.getLength(); ri++) {
        CSSRule rule = rules.item(ri);
        if (rule.getType() == CSSRule.MEDIA_RULE) {
            CSSMediaRule mr = (CSSMediaRule) rule;
            scanRules(mr.getCssRules(), classNameTest, ruleAction);
        } else if (rule.getType() == CSSRule.STYLE_RULE) {
            CSSStyleRuleImpl styleRule = (CSSStyleRuleImpl) rule;
            SelectorList selectors = styleRule.getSelectors();
            // if (!styleRule.getSelectorText().contains(".name"))
            //  continue; // selector text test might cause speed up...
            for (int si = 0; si < selectors.getLength(); si++) {
                Selector selector = selectors.item(si);
                Set<String> classNames = classNamesInSelectorMatching(selector, classNameTest);
                if (!classNames.isEmpty()) 
                    ruleAction.accept(classNames, styleRule);
            }
        }
    }
}

// find matching class names in given (potentially complex) selector
Set<String> classNamesInSelectorMatching(Selector selector,
        Predicate<String> nameMatches) {
    switch (selector.getSelectorType()) {
        case Selector.SAC_CHILD_SELECTOR:
        case Selector.SAC_DESCENDANT_SELECTOR:
        case Selector.SAC_DIRECT_ADJACENT_SELECTOR: {
            DescendantSelector ds = (DescendantSelector) selector;
            Set<String> set = new HashSet<>();
            set.addAll(classNamesInSelectorMatching(ds.getAncestorSelector(), nameMatches));
            set.addAll(classNamesInSelectorMatching(ds.getSimpleSelector(), nameMatches));
            return set;
        }
        case Selector.SAC_NEGATIVE_SELECTOR: {
            NegativeSelector ns = (NegativeSelector) selector;
            return classNamesInSelectorMatching(ns.getSimpleSelector(), nameMatches);
        }
        case Selector.SAC_CONDITIONAL_SELECTOR: {
            ConditionalSelector ns = (ConditionalSelector) selector;
            return classNamesInConditionMatching(ns.getCondition(), nameMatches);
        }
        default:
            return Collections.emptySet();
    }
}

// find matching class names in given (potentially complex) condition
Set<String> classNamesInConditionMatching(Condition condition,
        Predicate<String> nameMatches) {
    switch (condition.getConditionType()) {
        case Condition.SAC_CLASS_CONDITION: {
            AttributeCondition ac = (AttributeCondition) condition;
            if (nameMatches.test(ac.getValue()))
                return Collections.singleton(ac.getValue());
            else
                return Collections.emptySet();
        }
        case Condition.SAC_AND_CONDITION:
        case Condition.SAC_OR_CONDITION: {
            CombinatorCondition cc = (CombinatorCondition) condition;
            Set<String> set = new HashSet<>();
            set.addAll(classNamesInConditionMatching(cc.getFirstCondition(), nameMatches));
            set.addAll(classNamesInConditionMatching(cc.getSecondCondition(), nameMatches));
            return set;
        }
        case Condition.SAC_NEGATIVE_CONDITION: {
            NegativeCondition nc = (NegativeCondition) condition;
            return classNamesInConditionMatching(nc.getCondition(), nameMatches);
        }
        default:
            return Collections.emptySet();
    }
}