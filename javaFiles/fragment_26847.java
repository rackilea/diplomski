final FileInputStream ins = new FileInputStream("archive.tar");
// Zip starts at 0x1f6400, size is not needed
long toSkip = 0x1f6400;
// Safe skipping
while(toSkip > 0)
    toSkip -= ins.skip(toSkip);

final ZipInputStream zipin = new ZipInputStream(ins);
ZipEntry ze;
while((ze = zipin.getNextEntry()) != null)
{
    final byte[] content = new byte[(int)ze.getSize()];
    int offset = 0;
    while(offset < content.length)
    {
        final int read = zipin.read(content, offset, content.length - offset);
        if(read == -1)
            break;
        offset += read;
    }
    // DEBUG: print out ZIP entry name and filesize
    System.out.println(ze + ": " + offset);
}
zipin.close();