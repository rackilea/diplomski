String input = "\"labels\": \"\\\"label_name\\\": \\\"Webapp\\\",\"";

String result = input.replaceAll(
    "(\"\\w+\")\\s*:[^:]+:\\s*\\\\\\\"(\\w+)\\\\\\\",\"", 
    "$1: \\[\"$2\"\\]");

System.out.println(result1); // "labels": ["Webapp"]