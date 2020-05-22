/* Returns a newly-allocated buffer containing the contents of `data',
 * padded out to a multiple of 8 bytes using PKCS #5 style padding.
 *
 * If `padded_len` is non-NULL, the value it points to is updated to
 * the size of the padded output data.
 *
 * Returns NULL on error.
 */
char *pad_pkcs5(const char *data, size_t data_len, size_t *padded_len)
{
    char *padded_data;
    unsigned padding_len = 8 - (data_len % 8);
    const char padding = padding_len;
    char *pad_ptr;

    /* check for length overflow */
    if (data_len + padding_len < data_len)
        return NULL;

    /* Copy data into a new buffer and pad it out */
    padded_data = malloc(data_len + padding_len);

    if (!padded_data)
        return NULL;

    memcpy(padded_data, data, data_len);

    if (*padded_len)
    {
        *padded_len = data_len + padding_len;
    }

    /* Add the padding bytes */
    pad_ptr = padded_data + data_len;
    while (padding_len--)
    {
        *pad_ptr++ = padding;
    }

    return padded_data;
}

/* Returns a newly-allocated buffer containing the contents of `data',
 * encrypted with `key' using DES/ECB/PKCS5.
 *
 * If `out_len` is non-NULL, the value it points to is updated to
 * the size of the encrypted output data (which will always be a
 * multiple of 8).
 *
 * Returns NULL on error.
 */
char *ecb_pkcs5_encrypt(const char *key, const char *data, size_t data_len, size_t *out_len)
{
    char des_key[8];
    char *padded_data;
    size_t padded_len;
    int status;

    /* One of the few cases where strncpy() is exactly what we want! */
    strncpy(des_key, key, sizeof des_key);
    des_setparity(des_key);

    padded_data = pad_pkcs5(data, data_len, &padded_len);

    if (!padded_data)
        return NULL;

    status = ecb_crypt(des_key, padded_data, padded_len, DES_ENCRYPT);

    if (DES_FAILED(status))
        return NULL;

    if (out_len)
        *out_len = padded_len;

    return padded_data;
}