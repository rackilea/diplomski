if (_files.get(i).getAbsolutePath().contains("."))
                    entry = new ZipEntry(_files
                            .get(i)
                            .getAbsolutePath()
                            .substring(
                                    _files.get(i).getAbsolutePath()
                                            .lastIndexOf("/") + 1));