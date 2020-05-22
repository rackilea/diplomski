public abstract class Paper {
    String pid;
    String title;
    String author;

    public void update(PaperUpdateBundle bundle)
    {
        pid = bundle.getPID();
        title = budnle.getTitle();
        author = bundle.getAuthor();
    }
}


public class Publication extends Paper {
    int pages;

    public void update(PaperUpdateBundle bundle)
    {
       super.update(bundle);
       pages = bundle.getPages();
    }
}

public class PHDThesis {
    String supervisor;


    public void update(PaperUpdateBundle bundle)
    {
       super.update(bundle);
       supervisor = bundle.getSupervisor();
    }
}

public interface PaperUpdateBundle
{
    String getPID();
    String getTitle();
    String getAuthor();
    int getPages();
    String getSupervisor();
}