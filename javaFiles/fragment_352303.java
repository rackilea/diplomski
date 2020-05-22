GZipStream zip = new GZipStream(new FileStream("java.gz", FileMode.Open), CompressionMode.Decompress);
// Excuse me if there was an easier way to read the strings.
int character = zip.ReadByte();
while (character != -1)
{
    Console.Write((char)character);
    character = zip.ReadByte();
}
Console.ReadLine();