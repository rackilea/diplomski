@Override
protected AccessDecisionManager accessDecisionManager()
{
    try {
        AffirmativeBased ab = (AffirmativeBased) super.accessDecisionManager();
        List<AccessDecisionVoter<? extends Object>> advs = ab.getDecisionVoters();
        ResourceBasedPreInvocationAdvice expressionAdvice = new ResourceBasedPreInvocationAdvice();

        List<AccessDecisionVoter<? extends Object>> toBeRemoved = new ArrayList<>();
        for (AccessDecisionVoter<? extends Object> adv : advs) {
            if (adv instanceof PreInvocationAuthorizationAdviceVoter) {
                toBeRemoved.add(adv);
            }
        }
        for (AccessDecisionVoter<? extends Object> adv : toBeRemoved) {
            advs.remove(adv);
        }
        advs.add(new PreInvocationAuthorizationAdviceVoter(expressionAdvice));
        return ab;
    }
    catch (ClassCastException ex) {
        ArrayList decisionVoters = new ArrayList();
        ResourceBasedPreInvocationAdvice expressionAdvice = new ResourceBasedPreInvocationAdvice();
        decisionVoters.add(new PreInvocationAuthorizationAdviceVoter(expressionAdvice));
        return new AffirmativeBased(decisionVoters);
    }
}