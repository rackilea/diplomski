ftpFiles.stream()
        .map(FTPFile::getName)
        .filter(name -> name.startsWith(prefix))
        .map(name -> {
                name = name.substring(name.indexOf('_')+1);
                try {
                    return dateFormat.parse(name);
                } catch (ParseException e) {
                    throw new IllegalArgumentException(e);
                }
            })
        .max(Comparator.naturalOrder())
        .map(date -> prefix+'_'+dateFormat.format(date))
        .flatMap(fileName -> ftpFiles.stream()
                               .filter(file -> file.getName().equals(fileName)).findAny())
        .ifPresent(System.out::println);