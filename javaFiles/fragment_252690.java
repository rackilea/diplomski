private static void createJar(File source, JarOutputStream target) {
        createJar(source, source, target);
    }



 private static void createJar(File source, File baseDir, JarOutputStream target) {
        BufferedInputStream in = null;

        try {
            if (!source.exists()){
                throw new IOException("Source directory is empty");
            }
            if (source.isDirectory()) {
                // For Jar entries, all path separates should be '/'(OS independent)
                String name = source.getPath().replace("\\", "/");
                if (!name.isEmpty()) {
                    if (!name.endsWith("/")) {
                        name += "/";
                    }
                    JarEntry entry = new JarEntry(name);
                    entry.setTime(source.lastModified());
                    target.putNextEntry(entry);
                    target.closeEntry();
                }
                for (File nestedFile : source.listFiles()) {
                    createJar(nestedFile, baseDir, target);
                }
                return;
            }

            String entryName = baseDir.toPath().relativize(source.toPath()).toFile().getPath().replace("\\", "/");
            JarEntry entry = new JarEntry(entryName);
            entry.setTime(source.lastModified());
            target.putNextEntry(entry);
            in = new BufferedInputStream(new FileInputStream(source));

            byte[] buffer = new byte[1024];
            while (true) {
                int count = in.read(buffer);
                if (count == -1)
                    break;
                target.write(buffer, 0, count);
            }
            target.closeEntry();
        } catch (Exception ignored) {

        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception ignored) {
                    throw new RuntimeException(ignored);
                }
            }
        }
    }