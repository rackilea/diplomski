public String[] toStringArray(List<RoomClassRes> rooms) {
    String[] result = new String[rooms.size()];
    for (int index = 0; index < rooms.size(); index++)
        result[index] = rooms.get(index).getName();
    return result;
}