import java.util.*;

public class Test
{
    @SuppressWarnings("unchecked")
    public static void main (String[] args)
    {
        AbstractMap.SimpleEntry[] entries = {
            new AbstractMap.SimpleEntry("campaignId", 4770L),
            new AbstractMap.SimpleEntry("campaignId", 4936L),
            new AbstractMap.SimpleEntry("lazy", true),
            new AbstractMap.SimpleEntry("lazy", false)
        };
        for (AbstractMap.SimpleEntry entry : entries) {
            System.out.println(entry + ": " + entry.hashCode());
        }
    }
}