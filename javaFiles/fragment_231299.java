@RequestMapping(value = "/mycustom.css")
    public @ResponseBody
    byte[] getMessages(final HttpSession session,  final Principal principal) {
        StringBuffer sb = new StringBuffer("");
        sb.append("/* some css*/");
        return sb.toString().getBytes(Charset.forName("ISO-8859-1"));

}