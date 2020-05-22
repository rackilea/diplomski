Path startPath = Paths.get("pathToYourDirectoryWithTheFiles");
    try {
        Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

                if (Files.isRegularFile(file)) {
                    String filename = file.getFileName().toString();

                    Pattern stringPattern = Pattern.compile("\\w*-(\\w*)\\.pdf");
                    Matcher matcher = stringPattern.matcher(filename);
                    if (matcher.find()) {
                        String dealer = matcher.group(1);

                        System.out.println(dealer);

                        // String mail = getMailForDealer(dealer);
                        // sendMailToDealer(mail,file);
                    }

                }

                return FileVisitResult.CONTINUE;
            }
        });
    } catch (IOException e) {
        e.printStackTrace();
    }