@RequestMapping(value = "/TaskUpdateStatus")
public void TaskUpdateStatus(Long idTask, Long idStatus, HttpSession httpSession, HttpServletResponse resp) throws IOException {

  String result = new String();
  try {
    //... do DAO opperations to persist, everything Ok...
    resp.getWriter().write("Status changed from "
          + oldStatusName + " to " +   newStatusName);
    resp.setStatus(200);
  }
  catch(Exception e) {
    //... take care of exceptions
  }

}