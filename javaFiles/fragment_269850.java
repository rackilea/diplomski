File parentDir = "src";//dir from which you want the relative path

String relPath = source.getCanonicalPath()
                  .substring(parentDir.getCanonicalPath().length() + 1,
                             source.getCanonicalPath().length());

JarEntry entry = new JarEntry(relPath.replace(("\\", "/"));
...