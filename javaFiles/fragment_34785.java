public static EnumStatus getById(Long id) {
    for(EnumStatus e : values()) {
        if(e.id.equals(id)) return e;
    }
    return UNKNOWN;
}