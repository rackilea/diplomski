template <typename T>
void write_data(T x) {
    std::cout << get_type_name<T>() << ":" << x << std::endl;
}

template<>
void write_data<double>(double x) {
    union {
        double d;
        int64_t i;
    } n;
    n.d = x;
    std::cout << "double_as_int64:" << n.i << std::endl; 
}

template<>
void write_data<float>(double x) {
    union {
        float f;
        int32_t i;
    } n;
    n.f = x;
    std::cout << "float_as_int32:" << n.i << std::endl; 
}