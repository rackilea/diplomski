for (count = 0; count < user_str.length(); count++)
        {
            str_compare = user_str.charAt(count);
            for (int a : vowels)
            {
                if (a == str_compare)
                {
                    v_counter++;
                }
            }
        }