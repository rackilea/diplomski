String str = "Australia@2@India@30@UK@4@USA@43";

    String[] arr = str.split("(?<![a-zA-Z])@(?<!\\d)");

    StringBuilder builder = new StringBuilder();

    for(int i = arr.length - 1; i >= 0; i--) {
        builder.append(arr[i] + "@");
    }

    // Remove the last `@`
    builder = builder.replace(builder.lastIndexOf("@"), 
                              builder.lastIndexOf("@") + 1, "");

    System.out.println(builder.toString());