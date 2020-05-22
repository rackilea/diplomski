String string = "Lun. 08:00 - 12:15 13:15 - 16:15 Mar. 08:00 - 12:15 13:15 - 16:15 Mer. 08:00 - 12:15 13:15 - 16:15 Jeu. 08:00 - 12:15 13:15 - 16:15 Ven. 08:00 - 12:15 13:15 - 16:15 ";
        final Pattern pattern = Pattern.compile("((Lun|Mar|Mer|Jeu|Ven|Sam)\\. [0-9 \\-:]*)");
        final Matcher matcher = pattern.matcher(string);
        List<String> list = new ArrayList<String>();
        while (matcher.find())
        {   
            list.add(matcher.group(1));
        }

        for(String str : list)
        {
            System.out.println(str);
        }