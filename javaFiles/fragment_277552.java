public static void XmlImport()
    {
        var xmlPubKey = "<RSAKeyValue>\n\t<Modulus>AI0hSZ3hcfJHv1TPSIkT0XeW/HMPPFJMw4/aX5NxfhyVacpb5u6rucDztVNG1pXaBdya9OdO1+mGG250y+QuqP/70uu5QMcMEpCdp8xl0i+cUN9+fHDzse4XR/Kdrl3pKAefSR5QQX8xBScjTO+H+9fXVrrU9TQU6WXmahQnDwDJ</Modulus>\n\t<Exponent>AQAB</Exponent>\n</RSAKeyValue>\n";
        var rsa = RSA.Create();
        rsa.FromXmlString(xmlPubKey);
        Console.WriteLine(rsa.ToXmlString(false));
    }