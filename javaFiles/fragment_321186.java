public static void fillEmailsHashSet(String line,HashSet<String> container){

        Pattern p = Pattern.compile("([\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Za-z]{2,4})");
        Matcher m = p.matcher(line);

        while(m.find()) {
            container.add(m.group(1));
        }

    }