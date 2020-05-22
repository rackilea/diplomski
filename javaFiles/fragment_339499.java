String str = "Where is my dog, john ? % your dog is on the table % really thanks john " +
             "% you're welcome % Have a nice dog";

String dogString = Arrays.stream(str.split("%"))            // String[]  
                     .filter(s -> s.contains("dog"))        // check if each string has dog
                     .collect(Collectors.joining("//"));    // collect to one string