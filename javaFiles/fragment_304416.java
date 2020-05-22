String result = "";

if (buffer.length()>=16)
{
    result = buffer.toString().substring(0, 15);
}
else
{
    result = buffer.toString();
}

return result;