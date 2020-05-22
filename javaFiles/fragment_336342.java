private static void forwardData(int threadId, Socket inputSocket, Socket outputSocket, Integer length, boolean isPost) {
    int cLength = -1;
    int count = 0;
    try {
        InputStream inputStream = inputSocket.getInputStream();
        try {
            OutputStream outputStream = outputSocket.getOutputStream();
            try {
                byte[] buffer = new byte[4096];
                int read;
                if (length == null || length > 0) {
                    do {
                        if ((read = inputStream.read(buffer)) > 0) { // search for "Content-Length: "
                            if (cLength == -1) {
                                String response = new String(buffer, "UTF-8");
                                int pos = response.indexOf("Content-Length:");
                                if (pos > 0) {
                                    String lString = response.substring(pos + 16, pos + 24).replaceAll("([0-9]*).*\\n?\\r?.*", "$1");
                                    cLength = Integer.parseInt(lString);
                                }
                            }

                            if (cLength != -1) { // if length is given, count bytes from empty line on
                                if (count > 0) { // already started  - so just add
                                    count = count + read;
                                } else { // check if empty line exists,  "\r\n\r\n" or "\r\r"
                                    for (int n = 0; n < read; n++) {
                                        if (buffer[n] == 13 && buffer[n + 1] == 13) {
                                            count = read - (n + 2); // if so, set count to bytes read after the empty line
                                        }
                                        if (buffer[n] == 13 && buffer[n + 1] == 10 && buffer[n + 2] == 13 && buffer[n + 3] == 10) {
                                            count = read - (n + 4); // same as above
                                        }
                                    }
                                }
                            }

                            outputStream.write(buffer, 0, read);
                            if (inputStream.available() < 1) {
                                outputStream.flush();
                            }
                            if (length != null) {
                                length = length - read;
                            }
                        }
                    } while (read >= 0 && (length == null || length > 0) && (cLength == -1 || count < cLength));
                }

            } finally {
                if (!outputSocket.isOutputShutdown()) {
                    if (!isPost) {
                        outputSocket.shutdownOutput();
                    }
                }
            }
        } finally {
            if (!inputSocket.isInputShutdown()) {
                inputSocket.shutdownInput();
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}