@RequestMapping("upload")
    public String upload(MultipartRequest multipartRequest) {

        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
        MultipartFile[] files = fileMap.values().toArray(new MultipartFile[0]);

        // Use when the same parameter name is assigned to multiple files.
        // MultiValueMap<String, MultipartFile> multiFileMap = multipartRequest.getMultiFileMap();
        // MultipartFile[] files = multiFileMap.values().stream().flatMap(values -> values.stream()).toArray(MultipartFile[]::new);

        for (MultipartFile multipartFile : files) {
            System.out.println("param name: " + multipartFile.getName());
            System.out.println("filename: " + multipartFile.getOriginalFilename());
            System.out.println("size: " + multipartFile.getSize());

        }

        return ".....";
    }