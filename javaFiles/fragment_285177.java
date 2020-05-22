Function<ParkingWebApiDTO, Date> function = new Function<ParkingWebApiDTO, Date>() {
  @Override
  public Date apply(ParkingWebApiDTO dto) {
    return dto.getStartDate();
  }
};