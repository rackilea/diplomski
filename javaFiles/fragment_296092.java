String codeTypes[] = { "sample_code", "code", "formal_code" };
    Arrays.sort(codeTypes, Comparator.comparing(String::length).reversed());

    String id = "123456789_sample_code_xyz";
    Optional<String> codeType = Arrays.stream(codeTypes).filter(id::contains).findFirst();
    codeType.ifPresent(System.out::println);