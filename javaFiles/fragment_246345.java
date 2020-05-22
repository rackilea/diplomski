static const char characters[] = "0123456789ABCDEF";
std::string result (SHA256_DIGEST_LENGTH * 2, ' ');
for(int i = 0; i < SHA256_DIGEST_LENGTH; i++)
{
    result[2*i] = characters[(unsigned int) hash[i] >> 4];
    result[2*i+1] = characters[(unsigned int) hash[i] & 0x0F];
}
return result;