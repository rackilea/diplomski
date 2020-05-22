public static boolean containsId(List<DTO> list, long id) {
    for (DTO object : list) {
        if (object.getId() == id) {
            return true;
        }
    }
    return false;
}