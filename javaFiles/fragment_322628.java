String extractText(String s) throws IOException
{
    String html = fj.toHtmlString(s); 
    String filtered_text="";
    System.out.println("extracted \n\n");
    html=html.replaceAll("(?i)</strong>", "");
    html=html.replaceAll("(?i)<strong[^>]*>", "");
    filtered_text = html;        
    long end = System.currentTimeMillis();
    System.out.println("loop end in "+(end-start)/1000+" seconds"+" or "+(end-start)+" miliseconds");//System.out.println(++i2+" th loop end in "+(end-start)/1000+" seconds");
    return filtered_text;
}