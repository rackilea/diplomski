Formatter f = new Formatter(new File("DataResults2"), "Windows-1252",
                            Locale.US); // Latin-1 on Windows, US, Part of Europe
Formatter f = new Formatter(new File("DataResults2"), "UTF-8",
                            Locale._US); // International Unicode, US number notation

f.close();