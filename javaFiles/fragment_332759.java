float int_to_float(uint32_t in) {
    union {
        float f;
        uint32_t i;
    } u;

    u.i = in;
    return u.f;
}