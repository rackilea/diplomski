String s =  "IT&&faculty('Mousum handique'|'Abhijit biswas'|'Arnab 
paul'|'Bhagaban swain')\n" + 
                " Mousum handique(designation|address|phone number|'IT Assistant           professor'|<AUS staff quaters>|#5566778899#)\n" + 
                " Abhijit biswas(designation|address|phone number|'IT Assistant professor'|<AUW staff quaters>|#5566778891#)\n" + 
                "Arnab paul(designation|address|phone number|'IT Assistant professor'|<AUE staff quaters>|#5566778890#)\n" + 
                "Bhagaban swain(designation|address|phone number|'IT Assistant professor'|<AUW staff quarters>|#5566778892#)";
        Matcher m = Pattern.compile("(?m)^\\s*([^\\(]+)\\([^\\)]*\\|<([^>]*)>[^\\)]*\\|#([^#]*)#[^\\)]*\\)").matcher(s);
        while(m.find())
        {
            System.out.println(m.group(1));
            System.out.println(m.group(2));
            System.out.println(m.group(3));
        }