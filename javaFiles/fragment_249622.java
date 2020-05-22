String[] words = input.split(" ");  // split input string on space

for (int i = 0; i < words.length; i++) {  // iterate over array
    if (words[i].length() >= wordLength) {
        count++;
    }
}

System.out.println(count);