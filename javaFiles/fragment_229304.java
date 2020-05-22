public void handleTemplateException(TemplateException te, Environment env, Writer out) throws TemplateException {

    boolean externalPw = out instanceof PrintWriter;
    PrintWriter pw = externalPw ? (PrintWriter) out : new PrintWriter(out);
    try {
        pw.print("<!-- ERROR MESSAGE STARTS HERE -->"
                + "<!-- ]]> -->"
                + "</table></table></table>"
                + "<div align='left' style='"
                + "background-color:#FFFF7C; "
                + "display:block; "
                + "border-top:double; "
                + "padding:10px; "
                + "'>");
        pw.print("<b style='"
                + "color: red; "
                + "font-size:14px; "
                + "font-style:normal; "
                + "font-weight:bold; "
                + "'>"
                + "Oops! We have encountered a problem. Please try again!"
                + "</b>");
        pw.println("</div></html>");
        pw.flush();  // To commit the HTTP response
    } finally {
        if (!externalPw) pw.close();
    }

    throw te;
}