File file = new File("C:\\document.doc");
RestTemplate rest = new RestTemplate();
LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();

map.add("param1", param1);
map.add("param2", param2);
map.add("file", new FileSystemResource(file));            
Long response = rest.postForObject(url, map, Long.class);