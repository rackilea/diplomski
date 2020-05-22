if (b.getContentType().contains("multipart"))
{
    mp = (Multipart)b.getContent();
    j = -1;
    continue;
}