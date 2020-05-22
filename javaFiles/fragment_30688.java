Map<Supplier<Object>, Consumer<String>> mapThis = Map.of(
        waybillData::getEtimName, dto::setEtimName,
        waybillData::getVehicleNo, dto::setBusNo,
        waybillData::getIssuedTickets, dto::setIssuedTickets,
        waybillData::getIssuedRolls, dto::setIssuedRolls,
        waybillData::getWaybillStatus, dto::setStatus,
        waybillData::getFuel, dto::setFuel
        );
mapThis.entrySet().stream().forEach(e -> {
    Optional.ofNullable(e.getKey().get()).map(Objects::toString).ifPresent(e.getValue());
});