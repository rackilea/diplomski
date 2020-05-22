WINADVAPI
BOOL
WINAPI
GetUserNameA (
    __out_ecount_part_opt(*pcbBuffer, *pcbBuffer) LPSTR lpBuffer,
    __inout LPDWORD pcbBuffer
    );
WINADVAPI
BOOL
WINAPI
GetUserNameW (
    __out_ecount_part_opt(*pcbBuffer, *pcbBuffer) LPWSTR lpBuffer,
    __inout LPDWORD pcbBuffer
    );
#ifdef UNICODE
#define GetUserName  GetUserNameW
#else
#define GetUserName  GetUserNameA // <-- HERE!
#endif // !UNICODE