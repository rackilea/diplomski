if (line.charAt(i) == '-')
                {
                    // parse first year
                    yr = line.substring(yearStart,i);
                    year = Integer.parseInt(yr);
                    yearStart = i + 1; // reset to parse second year
                }
                else if (line.charAt(i) == ')')
                {
                    yr = line.substring(yearStart,i);
                    year = Integer.parseInt(yr);
                    break; // year found
                }