// headers
while ((line = in.readLine()) != null
{
    if (line.length() == 0)
        break; // end of headers
    // ...
}

// body
while ((count = in.read(buffer)) > 0)
{
    out.write(buffer, 0, count);
}