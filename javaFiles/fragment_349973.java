#if __GNUC__ >= 4
    #define DLL_PUBLIC __attribute__ ((visibility ("default")))
    #define DLL_LOCAL  __attribute__ ((visibility ("hidden")))
#else
    #define DLL_PUBLIC
    #define DLL_LOCAL
#endif

DLL_PUBLIC void My_OpenSSL_add_all_algorithms() {

    return (void)OpenSSL_add_all_algorithms();
}

DLL_PUBLIC void My_SSL_load_error_strings() {

    return (void)SSL_load_error_strings();
}
...