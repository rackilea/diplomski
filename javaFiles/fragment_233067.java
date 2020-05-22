finally
{
    try{ if (is != null) is.close(); } catch (IOException ignored) {}
    try{ if (isr != null) isr.close(); } catch (IOException ignored) {}
    try{ if (br != null) br.close(); } catch (IOException ignored) {}
}