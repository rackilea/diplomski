if(wkhtmltopdf_convert(conv))
{
    // Get Output as buffer
   const unsigned char *data = nullptr;
   size_t length = wkhtmltopdf_get_output(conv, &data);
   ....
}