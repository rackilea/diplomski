int limit = 0;
for (XtfPing ping : xtf.getPings())
{
    if (limit <= 10000) {
        // do something
    } else {
        // do something else
    }
    limit++;
}