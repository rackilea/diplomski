class DealerFilter implements FilenameFilter
{
    private final String dealer;

    DealerFilter(String dealer)
    {
        this.dealer = dealer;
    }

    @Override
    public boolean accept(File dir, String name)
    {
        // uncomment these lines for debugging:
        //System.out.println ("dealer: " + dealer);
        //System.out.println ("name:   " + name);
        //System.out.println ("dir:    " + dir);

        return name.toLowerCase().endsWith("-" + dealer.toLowerCase() + ".pdf");
    }
}

// returns null if error, empty array if not found
File[] findDealerPDFs(String directory, String dealer)
{
    File dir = new File(directory);

    File[] files = dir.listFiles(new DealerFilter(dealer));
    if (files == null)
    {
        // error
        return null;
    }
    for (File f : files)
    {
        System.out.println(f);
    }
    return files;
}