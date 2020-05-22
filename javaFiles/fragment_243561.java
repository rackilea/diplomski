private void setResponseHeaderTXT(HttpServletResponse response) {
    response.setContentType("text/plain; charset=UTF-8");
    response.setHeader("content-disposition", "attachment; filename=imenik.txt" );
} 
@RequestMapping(value = "/exportPhonebook.html", method = RequestMethod.POST)
public void exportPhonebook(Model model, HttpServletResponse response) {

    List<User> listOfAllUsers = phoneBookSer.fetchAllUsers();
    String phonebook = "";

    for (User user : listOfAllUsers) {
        phonebook = phonebook + user.getSurname() + " " + user.getName() + ", + 
        ", Phone number: " + user.getPhoneNumber() + ";\r\n" ;
    }

    try {
        setResponseHeaderTXT(response);
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(phonebook.getBytes(Charset.forName("UTF-8")));
        outputStream.flush();
        outputStream.close();
    } catch (IOException e) {
        e.printStackTrace();
    }   
}