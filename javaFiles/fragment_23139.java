for(Element dc : doc.select("div#doc.uh3-p uh3lite"))
    {
        System.out.println("data");

        for(Element dd : dc.select("div#bd")) // note doc was changed to dc
        {
            for(Element results : dd.select("div#results")) // note doc was changed to dd
            {
                // etc...