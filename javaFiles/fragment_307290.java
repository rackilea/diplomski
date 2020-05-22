FileInputStream input = new FileInputStream(f);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                int bytesRead = input.read(buf);
                while (bytesRead != -1) {
                    baos.write(buf, 0, bytesRead);
                  bytesRead = input.read(buf);
                }
                baos.flush();
                byte[] bytes = baos.toByteArray();