190            FileInputStream keyStoreInputStream = null;
191            try {
192                keyStoreInputStream = ((this.keyStorePath != null) && (!"NONE"
193                        .equals(this.keyStorePath))) ? new FileInputStream(
194                        this.keyStorePath) : null;
195                keyStore.load(keyStoreInputStream, this.keyStorePassword);