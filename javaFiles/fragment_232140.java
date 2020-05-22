Pattern compile1 = Pattern.compile("margin:\\s*((-?\\.?\\d+(?:em|px|%)\\s*){1,4})");
    Matcher matcher1 = compile1.matcher(style);

    if (matcher1.find())
    {
        String[] split = matcher1.group(1).trim().split("\\s+");
        String marginBottom;

        if (split.length < 3)
        {
            marginBottom = split[0];
        } else
        {
            marginBottom = split[2];
        }

        if (marginBottom.contains("-"))
        {
            System.err.println("Bottom margin is negative "  + marginBottom);
        }
    }