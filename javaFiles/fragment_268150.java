public static Plan findMatchingPlan(List<Plan> plans, String id) {
    return plans.stream()
                .filter(plan -> plan.getRequestList()
                                    .stream()
                                    .filter(request -> ! request.isCancelled())
                                    .flatMap(request -> request.getIdentityList().stream())
                                    .anyMatch(identity -> identity.getIdNumber().equals(id)))
                .findFirst()
                .orElse(null);
}