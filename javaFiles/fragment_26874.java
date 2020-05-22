final String location = "D:\\krishna\\sample.wav"
 File f = (File) AccessController.doPrivileged(new PrivilegedAction()
    {
        public Object run()
        {
            File outputFile = new File(location);
            return outputFile;
        }
    });