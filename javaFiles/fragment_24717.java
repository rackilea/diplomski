if(line.charAt(i) == ')' || line.charAt(i) == '-')//get year
                {
                    yr = line.substring(yearStart,i);
                    year = Integer.parseInt(yr);
                    break; // year found, no point in looping more
                }