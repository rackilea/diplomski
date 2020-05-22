try (Stream<Path> paths = Files.walk(Paths.get("c:/yourPath/"))) {
        List<FileUtil> listUtil = new ArrayList<FileUtil>();

        paths
            .filter(Files::isRegularFile)
            .map(filePath -> filePath.toFile())
            .collect(Collectors.toList())
            .forEach(file -> listUtil.add(new FileUtil(file.getName(), file)));

        Map<String, List<FileUtil>> collect = listUtil.stream()
                .collect(Collectors.groupingBy(FileUtil::getFileName));

        for(String key : collect.keySet() ) {
            List<FileUtil> list = collect.get(key);
            if(list.size() > 1) {
                list.stream().findFirst().ifPresent(f -> f.setDelete(false));

                list.stream()
                    .filter(fileUtil -> fileUtil.isDelete())
                    .forEach(fileUtil -> fileUtil.getFile().delete());
            }
        }


    } catch (IOException e) {
        e.printStackTrace();
    }