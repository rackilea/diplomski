class TwoObjectDTO {
    String string;
    List<Long> listOfNumbers;
}

@POST
Boolean deleteUsers(TwoObjectDTO object) {
    ...
}