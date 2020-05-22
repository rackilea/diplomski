users = Files.lines(Paths.get(file.getAbsolutePath()))
                    .map(line -> line.split(","))
                    .map(fields -> new MockUser(fields[0], fields[1], fields[2]))
                    .collect(Collectors.toMap(
                            MockUser::getUsername,
                            user -> user));