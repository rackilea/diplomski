public class Test2
{
    static string file_original;
    static byte[] file_orig_bytes;

    static void Main(string[] args)
    {
        byte[] AES_KEY = new byte[]{
            (byte) 0x2a, (byte) 0x5f, (byte) 0xcb, (byte) 0x17,
            (byte) 0x91, (byte) 0xd2, (byte) 0x2f, (byte) 0xb6,
            (byte) 0x02, (byte) 0x45, (byte) 0xb3, (byte) 0xd8,
            (byte) 0x36, (byte) 0x9e, (byte) 0xd0, (byte) 0xb2,
            (byte) 0xc2, (byte) 0x73, (byte) 0x71, (byte) 0x56,
            (byte) 0x3f, (byte) 0xbf, (byte) 0x1f, (byte) 0x3c,
            (byte) 0x9e, (byte) 0xdf, (byte) 0x6b, (byte) 0x11,
            (byte) 0x82, (byte) 0x5a, (byte) 0x5d, (byte) 0x0a,
            };

        string path = @"C:\temp_10\game.sii";
        load_file_to_memory(path);
        //decrypt_file(AES_KEY);
        byte[] iv = new byte[0x10];
        byte[] cipherText = new byte[file_orig_bytes.Length - 0x38];
        Array.Copy(file_orig_bytes, 0x38, cipherText, 0, cipherText.Length);
        Array.Copy(file_orig_bytes, 0x24, iv, 0, iv.Length);

        byte[] decoded_binary_content = AESDecrypt(cipherText, AES_KEY, iv);

        string decoded_string_content = "";
        using (MemoryStream ms = new MemoryStream(decoded_binary_content))
        using (ICSharpCode.SharpZipLib.Zip.Compression.Streams.InflaterInputStream iis = new ICSharpCode.SharpZipLib.Zip.Compression.Streams.InflaterInputStream(ms))
        using (StreamReader sr = new StreamReader(iis))
            decoded_string_content = sr.ReadToEnd();
    }

    private static void load_file_to_memory(string path)
    {
        file_original = File.ReadAllText(path);
        file_orig_bytes = File.ReadAllBytes(path);
    }

    //http://lamahashim.blogspot.it/2009/08/encyptiondecryption-in-c-and-java.html
    static byte[] AESDecrypt(byte[] encryptedData, byte[] keyBytes, byte[] iv)
    {
        RijndaelManaged rijndaelCipher = new RijndaelManaged();
        rijndaelCipher.Mode = CipherMode.CBC;
        rijndaelCipher.Padding = PaddingMode.None;
        rijndaelCipher.IV = iv;

        rijndaelCipher.KeySize = 0x80;
        rijndaelCipher.BlockSize = 0x80;
        rijndaelCipher.Key = keyBytes;
        rijndaelCipher.IV = iv;
        byte[] plainText = rijndaelCipher.CreateDecryptor().TransformFinalBlock(encryptedData, 0, encryptedData.Length);
        return plainText;
    }
}