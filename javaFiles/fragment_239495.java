max = ans.length();
            }

            char beginChar = s.charAt(begin);
            if (tabl.containsKey(beginChar)) {
                int charCount = tabl.get(beginChar);