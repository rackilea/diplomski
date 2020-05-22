SCCSR *sccsr = [[SCCSR alloc] init];
    sccsr.commonName = @"some name";
    sccsr.organizationName = @"some organisation";
//    // aditional data you can set
//    sccsr.countryName = @"";
//    sccsr.organizationalUnitName = @"";
//    sccsr.subjectDER = nil;
//    //
//    
    NSData *certificateRequest = [sccsr build:pPublicKey privateKey:privateKey];

    NSString *str = [certificateRequest base64EncodedStringWithOptions:NSDataBase64Encoding64CharacterLineLength];

    NSString *strCertificateRequest = @"-----BEGIN CERTIFICATE REQUEST-----\n";
    strCertificateRequest = [strCertificateRequest stringByAppendingString:str];
    strCertificateRequest = [strCertificateRequest stringByAppendingString:@"\n-----END CERTIFICATE REQUEST-----\n"];