public String execute() 
    {  
        String bookid = request.getParameter("bid");    
        Bookdetails book = dao.listBookDetailsById(Integer.parseInt(bookid));
        books = (ArrayList) session.get( VisionBooksConstants.USER );  
        if ( books == null ) books = new ArrayList<Bookdetails>();
        boolean already_exists = false;
        for ( Bookdetails b : books ) {
            if ( b.getID().equals(bookid) ) {
                already_exists = true; break;
            }
        }
        if (book != null && !already_exists  ) 
        { 
            books.add(book);
            System.out.println("books size"+books.size()); 
            session.put(VisionBooksConstants.USER,books);
        }
        return SUCCESS;
    }