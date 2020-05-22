for(int i = 0; i < words.length; i++){
        int listCheck = inList(words[i], beforeList);
        if(listCheck != -1){
            words[i] = afterList[listCheck];
        }
    }

    ArrayList<String> newWords = new ArrayList<String>();

    for(int i = 0 ; i < words.length ; i++) {
        String str = words[i];
        if(str.contains(' ')){
            while(str.contains("  ")) {
                str = str.replace("  ", " ");
            }

            String[] subWord = str.split(" ");

            newWords.addAll(Arrays.asList(subWord));
        } else {
            newWords.add(str);
        }
    }

    return (String[])newWords.toArray();