public InputStream getErrorStream() {
        if(this.connected && this.responseCode >= 400) {
            if(this.errorStream != null) {
                return this.errorStream;
            }

        if(this.inputStream != null) {
            return this.inputStream;
        }
    }

    return null;
}