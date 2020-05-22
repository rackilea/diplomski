File file = File.createTempFile("aaa","bbb");
FileUtils.writeStringToFile(file, mapper.writeValueAsString(message), "UTF-8");

MultiValueMap<String, Object> values = new LinkedMultiValueMap<String, Object>();
values.add("name", file.getAbsolutePath());
values.add("filename", file.getAbsolutePath());
values.add("file", new FileSystemResource(file));

restTemplate.postForObject(URL, values, String.class);