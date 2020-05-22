while (true) {
        String word = reader.readLine();
        if("end".equalsIgnoreCase(word)) {
            break;
        }
        list.add(word);
    }
    for (String word : list) {
        System.out.println(word);
    }