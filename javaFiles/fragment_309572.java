public boolean lookAhead (int a) {
        Pattern error = Pattern.compile("^[^(\\s*NAME.*)(\\s*AGE.*)(\\s*ADDRESS.*)(\\s*BIRTHDAY.*)]");
        Pattern legit = Pattern.compile("^[(\\s*NAME.*)(\\s*AGE.*)(\\s*ADDRESS.*)(\\s*BIRTHDAY.*)");
        while ((line = buff.readLine()) != null) {                                
                 Matcher comment = pattern[4].matcher(line);
                 Matcher err = error.matcher(line);
                 Matcher leg = legit.matcher(line);
                 Matcher name = pattern[0].matcher(line);
                 Matcher age = pattern[1].matcher(line);
                 Matcher addr = pattern[2].matcher(line);
                 Matcher bd = pattern[3].matcher(line);
                 Matcher input = pattern[a].matcher(line);
                 if (!input.find() && (comment.find() || err.find() || (leg.find() && (!name.find() && !age.find() && !addr.find() && !bd.find())))               
                     continue;
                    Matcher dp = pattern[a].matcher(line);
                    dpla = dp.find();
                    break;
                 }
        }
        return dpla;
     }