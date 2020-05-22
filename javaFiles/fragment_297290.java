if(session==null) {
    session = request.getSession(true);
}
Invoice invoice = (Invoice) session.getAttribute("invoice");
if (invoice == null) {
  invoice = new Invoice();
}
session.setAttribute("invoice", invoice);

// Similarly for lines.