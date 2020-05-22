ccStatus = CCCrypt(encryptOrDecrypt,
        kCCAlgorithm3DES,
        kCCOptionECBMode, <-- this could help
        vkey, //"123456789012345678901234", //key
        kCCKeySize3DES,
        nil, //"init Vec", //iv,
        vplainText, //"Your Name", //plainText,
        plainTextBufferSize,
        (void *)bufferPtr,
        bufferPtrSize,
        &movedBytes);