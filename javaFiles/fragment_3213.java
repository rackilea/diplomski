@Named("season")
default Integer mapSeasonNumber(Program programInstance) {
    Optional<Integer> season = Utils.getObject(() -> programInstance.get(0).getSeasonOf().get(0).getOrderNo());
    if (season.isPresent())
        return season.get();
    return null;
}

@Named("epNumber")
default Integer mapEpNumber(Program programInstance) {
    Optional<Integer> epNumber = Utils.getObject(() -> programInstance.getEpOf().get(0).getOrderNo());
    if (epNumber.isPresent())
        return epNumber.get();
    return null;
}