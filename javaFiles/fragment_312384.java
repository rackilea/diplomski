String s = "Google     Android    Gmail    Youtube     Apple    iOS     Mac     Microsoft   Hewlett packard      Windows";

            String[] keywords = s.split("\\s+");

            String searchTerm = "Youtube";

            String endText = "";

            for(int index = 0; index < keywords.length; index++) {
                if(keywords[index].contentEquals(searchTerm)) {
                    if(index != (keywords.length - 1)) {
                        endText = endText + "..." + " " + searchTerm + " " + keywords[index + 1];
                    } else {
                        endText = endText + "..." + " " + searchTerm + " " + keywords[0];
                    }
                }
            }

// Here the endText would be: "... Youtube Apple"