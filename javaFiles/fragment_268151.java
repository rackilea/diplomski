public static Plan findMatchingPlan(List<Plan> plans, String id) {
    return plans.stream()
                .filter(plan -> plan.getRequestList()
                                    .stream()
                                    .filter(request -> ! request.isCancelled())
                                    .map(Request::getIdentityList)
                                    .flatMap(List::stream)
                                    .map(Identity::getIdNumber)
                                    .anyMatch(id::equals))
                .findAny()
                .orElse(null);
}