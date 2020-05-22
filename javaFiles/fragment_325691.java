vertx.fileSystem().rxReadFile("/home/lbulic/file.csv")
            .map(buffer -> buffer.toString("UTF-8"))
            .map(n -> n.split(","))
            .map(data -> new User(Long.parseLong(data[0]), data[1], data[2]))
            .subscribe(content -> System.out.println("Content: " + content),
                    err -> System.out.println("Cannot read the file: " + err.getMessage()));