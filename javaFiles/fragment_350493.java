enum Ganglia_msg_formats {
    gmetadata_full = 128,
    gmetric_ushort = 128 + 1,
    gmetric_short = 128 + 2,
    gmetric_int = 128 + 3,
    gmetric_uint = 128 + 4,
    gmetric_string = 128 + 5,
    gmetric_float = 128 + 6,
    gmetric_double = 128 + 7,
    gmetadata_request = 128 + 8,
};
typedef enum Ganglia_msg_formats Ganglia_msg_formats;