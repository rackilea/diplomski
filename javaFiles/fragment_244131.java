String example1 = "how are you?";
    String example2 = "how, are you... here?";
    String example3 = "Madam, how are you finding the accommodations?";
    String example4 = "how are you how are you how are you taco";

    String compound = "howareyou";

    StringBuilder compoundRegexBuilder = new StringBuilder();

    //This matches to a word boundary before the first word
    compoundRegexBuilder.append("\\b");

    // inserts each character into the regex
    for(int i = 0; i < compound.length(); i++) {
        compoundRegexBuilder.append(compound.charAt(i));

        // between each letter there could be any amount of whitespace
        if(i<compound.length()-1) {
            compoundRegexBuilder.append("\\s*");
        }
    }

    // Makes sure the last word isn't part of a larger word
    compoundRegexBuilder.append("\\b");

    String compoundRegex = compoundRegexBuilder.toString();
    System.out.println(compoundRegex);
    System.out.println("Example 1:\n" + example1 + "\n" + example1.replaceAll(compoundRegex, ""));
    System.out.println("\nExample 2:\n" + example2 + "\n" + example2.replaceAll(compoundRegex, ""));
    System.out.println("\nExample 3:\n" + example3 + "\n" + example3.replaceAll(compoundRegex, ""));
    System.out.println("\nExample 4:\n" + example4 + "\n"  + example4.replaceAll(compoundRegex, ""));