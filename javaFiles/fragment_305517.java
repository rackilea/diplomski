for (Map.Entry<String, Map<String, Set<String>>> entry : treeMap
                .entrySet()) {
            if (!entry.getValue().isEmpty()) {
                LibraryModel libraryModel = new LibraryModel(entry.getKey());
                root.addLibrary(libraryModel);
                for (Map.Entry<String, Set<String>> methodToFileEntry : entry
                        .getValue().entrySet()) {
                    MethodModel methodModel = new MethodModel(
                            methodToFileEntry.getKey());
                    libraryModel.addMethod(methodModel);
                    for (String fileName : methodToFileEntry.getValue()) {
                        FileModel fileModel = new FileModel(fileName, fileName);
                        methodModel.addFile(fileModel);
                    }
                }
            }
        }