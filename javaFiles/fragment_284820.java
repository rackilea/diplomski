String listSize = request.getParameter("listsize");
    int size = Integer.parseInt(listSize);
    ArrayList list = new ArrayList(size);
    for(int i=0;i<size;i++){
        list.add("test"+i);
    }
    request.setAttribute("MyList", list);
request.getRequestDispathcer("JSP FILE NAME").forward(request, response);