JsonDocument doc = userRepository.getCouchbaseOperations().getCouchbaseBucket().get("1");
    JsonDocument doc2 = userRepository.getCouchbaseOperations().getCouchbaseBucket().get("1");
    doc.content().put("username", "Michael");

    userRepository.getCouchbaseOperations().getCouchbaseBucket().replace(doc);

    doc2.content().put("username", "denis");
    userRepository.getCouchbaseOperations().getCouchbaseBucket().replace(doc2);

    User userResult2 = userRepository.findById("1").get();
    System.out.println(userResult2.getUsername());