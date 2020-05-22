private void btnKey_Click(object sender, EventArgs e)
{
    byte[] salt = new byte[] { 172, 137, 25, 56, 156, 100, 136, 211, 84, 67, 96, 10, 24, 111, 112, 137, 3 };
    int iterations = 1024;
    var rfc2898 = new System.Security.Cryptography.Rfc2898DeriveBytes("_sOme*ShaREd*SecreT", salt, iterations);
    byte[] key = rfc2898.GetBytes(16);
    String keyB64 = Convert.ToBase64String(key);
    txtRfc2898DeriveBytes.Text = keyB64;
}