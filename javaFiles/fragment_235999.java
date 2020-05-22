private byte[] zipLicense(byte[] lic)
{
    var outputMemStream = new MemoryStream();

    using (DeflateStream stream =
        new DeflateStream(outputMemStream, CompressionMode.Compress, true))
    {
        stream.Write(lic, 0, lic.Length);
    }

    Debug.WriteLine(string.Format("Compressed bytes: {0}", outputMemStream.Length));

    return outputMemStream.ToArray();
}