if (req.getParameter("addButton") !=null){
    add (req, resp);
} else if (req.getParameter("editButton") !=null){
    edit (req, resp);
} else if (req.getParameter("deleteButton") !=null){
    delete (req, resp);
} else if (req.getParameter("detailsButton") !=null){
    details (req, resp);
} else {
    browse(req, resp);
}