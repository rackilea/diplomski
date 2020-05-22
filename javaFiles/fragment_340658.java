Optional<FTPFile> max = ftpFiles.stream()
        .filter(file -> file.getName().startsWith(prefix))
        .max(Comparator.comparing(file -> {
                String name = file.getName();
                name = name.substring(name.indexOf('_')+1);
                try {
                    return dateFormat.parse(name);
                } catch (ParseException e) {
                    throw new IllegalArgumentException(e);
                }
            }));