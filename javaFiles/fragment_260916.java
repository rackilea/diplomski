public class Event
{
    public final String name;
    public final String title;
    public final String details;

    public Event(final String a_name,
                 final String a_title,
                 final String a_details)
    {
        name = a_name;
        title = a_title;
        details = a_details;
    }
};

public Event eventDetails(int m, int d) {
    if (some-condition)
        return new Event("my-name1", "my-title1", "mydetails1");
    else
        return new Event("my-name2", "my-title2", "mydetails2");
}

final Event e = eventDetails(1, 4);
name.setText(e.name);
title.setText(e.title);
details.setText(e.details);