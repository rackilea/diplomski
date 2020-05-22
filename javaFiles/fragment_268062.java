String replaced = Pattern.compile("\\$\\{[^}]+\\}|[A-Z]")
        .matcher(yourUrlString)
        .replaceAll(m -> {
            String match = m.group();
            if (match.length() == 1)
                return match.toLowerCase();
            else
                return Matcher.quoteReplacement(match); 
        });
System.out.println(replaced);