ASSERT(data.size() == RSA_size(rsa));
if(data.size() != RSA_size(rsa))
    CONSOLE_ERROR << "Invalid cipher text length" << endl;

int result = RSA_private_decrypt(RSA_size(rsa), (uchar*)data.data(), (uchar*)&dataDecryptedBuffer, rsa, RSA_PKCS1_PADDING);

ASSERT(result != -1);
if(result == -1)
    CONSOLE_ERROR << "Can't decrypt error code : " << std::hex << ERR_get_error();

QByteArray dataDecrypted(dataDecryptedBuffer, result);