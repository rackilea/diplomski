class PNGExtension implements FileExtension {

    @Override
    public String getExtension(byte[] buffer) {
        /* ----- PNG File Type Verification ----- */
        String fileType = null;
        if (buffer[0] == 0x89 && buffer[1] == 0x50 && buffer[2] == 0x4E && buffer[3] == 0x47 && buffer[4] == 0xD && buffer[5] == 0xA
                && buffer[6] == 0x1A && buffer[7] == 0xA) {
            fileType = ".png";
        }

        return fileType;
    }

}

class JPGExtension implements FileExtension {

    @Override
    public String getExtension(byte[] buffer) {
        /* ----- JPG File Type Verification ----- */
        String fileType = null;
        if (buffer[0] == 0xFF && buffer[1] == 0xD8 && buffer[2] == 0xFF && buffer[3] == 0xE0) {
            fileType = ".jpg";
        }

        return fileType;
    }

}