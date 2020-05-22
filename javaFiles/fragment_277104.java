StringBuilder sb = new StringBuilder(text);
    for(int i = 0; i<text.length(); i ++)
    {
        for (int j = 0; j < firstCharArray.length;j++)
        {
            if (sb.charAt(i) == firstCharArray[j])
            {
                sb.setCharAt(i, secondCharArray[j]);
                break;
            }

        }
    }