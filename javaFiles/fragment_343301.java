@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();
    User user = (User) session.getAttribute("user");
    String amount = req.getParameter("amount");
    String currencyid = req.getParameter("currency");
//Get your currency object from database
    Currency currencyToBeEdited = currencyDao.findById(Integer.parseInt(currencyid));

//Add the code to set the amount and save it back to the database

    Purse purse = new Purse(user, currency, new BigDecimal(amount), new Timestamp(System.currentTimeMillis()));

    purseDao.insert(purse);

    resp.sendRedirect("userPage");
}