for (int i = 0; i < words.length -1; i++) {
            String threeWords;
              if(i == words.length - 2)
                  threeWords = words[i] + " " + words[i + 1]; 
              else 
                  threeWords = words[i] + " " + words[i + 1] + " " + words[i + 2];
              System.out.println(threeWords);
    }