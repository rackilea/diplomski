DTO dto = new DTO();

Optional.ofNullable(waybillData.getEtimName()).ifPresent(dto::setEtimName);
Optional.ofNullable(waybillData.getVehicleNo()).ifPresent(dto::setBusNo);
Optional.ofNullable(waybillData.getIssuedTickets()).map(Objects::toString).ifPresent(dto::setIssuedTickets);
Optional.ofNullable(waybillData.getIssuedRolls()).map(Objects::toString).ifPresent(dto::setIssuedRolls);
Optional.ofNullable(waybillData.getWaybillStatus()).ifPresent(dto::setStatus);
Optional.ofNullable(waybillData.getFuel()).map(Objects::toString).ifPresent(dto::setFuel);