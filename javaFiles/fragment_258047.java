int row = 1;
while(true) {
    String code = request.getParameter("code-" + row);
    String title = request.getParameter("title-" + row);
    String author = request.getParameter("author-" + row);
    row++;
    if (code == null && title == null && author == null) { //or modify this to whatever you need
        break;        
    }
    //your process here
}