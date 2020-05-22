File file = new File(/path/to/directory/save.zip);
            if (file.exists() && file.isDirectory()) {
                try {
                    OutputStream outputStream = new FileOutputStream(new File(/path/to/directory/save.zip));
                    outputStream.write(bytes);
                    outputStream.close();
                } catch (IOException ignored) {

                }
            } else { // create directory and call same code }
}