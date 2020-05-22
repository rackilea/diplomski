String str1 = "<!--Address:google.co.uk.html-->";
        // Approach 1
        int st = str1.indexOf("<!--"); // gives index which starts from <
        int en = str1.indexOf("-->");  // gives index which starts from -
        str1 = str1.substring(st + 4, en);
        System.out.println(str1);

        // Approach 2
        String str2 = "<!--Address:google.co.uk.html-->";
        str2 = str2.replaceAll("[<>!-]", "");
        System.out.println( str2);