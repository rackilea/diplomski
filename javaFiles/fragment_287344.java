byte[] hash;
using (MD5 md5 = MD5.Create())
{
    hash = md5.ComputeHash(bytes);
}
// Use hash