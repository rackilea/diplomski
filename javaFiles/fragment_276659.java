1 pageContext = _jspxFactory.getPageContext(this, request, response, null, true, 8192, true);
2 _jspx_page_context = pageContext;
3 application = pageContext.getServletContext();
4 config = pageContext.getServletConfig();
5 session = pageContext.getSession();
6 out = pageContext.getOut();
7 _jspx_out = out;
8 out.write("<html><body>\r\n");
9 //  eg:log
10 examples.LogTag _jspx_th_eg_005flog_005f0 = (examples.LogTag) _005fjspx_005ftagPool_005feg_005flog.get(examples.LogTag.class);
11 _jspx_th_eg_005flog_005f0.setPageContext(_jspx_page_context);
12 _jspx_th_eg_005flog_005f0.setParent(null);
13 int _jspx_eval_eg_005flog_005f0 = _jspx_th_eg_005flog_005f0.doStartTag();
14 if (_jspx_eval_eg_005flog_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
15  if (_jspx_eval_eg_005flog_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
16    out = _jspx_page_context.pushBody();
17    _jspx_th_eg_005flog_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
18    _jspx_th_eg_005flog_005f0.doInitBody();
19  }
20  do {
21    out.write("It's ");
22    out.print("TEST");
23    int evalDoAfterBody = _jspx_th_eg_005flog_005f0.doAfterBody();
24    if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
25      break;
26  } while (true);
27  if (_jspx_eval_eg_005flog_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
28    out = _jspx_page_context.popBody();
29  }
30 }