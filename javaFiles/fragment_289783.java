String input[] = {
            "Xbox 360 (black) Elite Console 120GB (Mason City Illinois ) $200",
            "$200 2013 North Trail Camper (RT 202. Manchester, Maine) $224/mo.",
            "Snowmobile Bike trailers (Winthrop / Augusta) $40 Monthly",
            "\"Great Xmas Gift\" XBox 360 Guitar Hero (Springfied)"
    };
    for (String s : input) {
        int lastClose = s.lastIndexOf(')');
        int lastOpen = s.lastIndexOf('(', lastClose);
        System.out.println(s.substring(0, lastOpen).trim() +
                "~" + s.substring(lastOpen + 1, lastClose).trim() +
                "~" + s.substring(lastClose + 1).trim());
    }