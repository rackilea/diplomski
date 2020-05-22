MessageDigest sha1;
byte[] digest;

for (each zip file entry)
{
  if (entry represents a directory)
  {
    sha1.update( directory name bytes as UTF-8 );
  }
  else
  {
    read the entry bytes using ZipInputStream.read()
    sha1.update( bytes );
  }
}

digest = sha1.digest();