package com.magerman.hremail.prep1docc;

public class PDFDecryptor {

/**
 * Instantiates a new pDF decryptor.
 * 
 * @param inputFile
 *            the input file
 * @param inputPassword
 *            the input password
 */
public PDFDecryptor(final File inputFile, final String inputPassword) {
originalFile = inputFile;
password = inputPassword;
}

/**
 * Decrypt. Given an inputted PDF File, will try to remove the security of
 * the PDF and save in-place. Done after the attachments have been extracted
 */
public final void decrypt() {
// naughty code here
}


public final void doproviledgeddecrypt() throws Exception {
AccessController.doPrivileged(new PrivilegedExceptionAction() {
    public Object run() throws Exception {
    PDFDecryptor.this.decrypt();
    return null;
    }
});
}

}