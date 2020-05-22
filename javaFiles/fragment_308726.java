@RequestMapping("upload")
public String upload(@RequestParam MultiValueMap<String, MultipartFile> multiFileMap) {

    MultipartFile[] files = multiFileMap.values().stream().flatMap(values -> values.stream())
            .toArray(MultipartFile[]::new);
     .......
     return ......
}