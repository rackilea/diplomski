public class Consumer extends HttpServlet {
@Override
protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
throws ServletException, IOException {
try {
...
MessageListener listener = new MessageListener() {
public void onMessage(Message msg) {
....
}
};
....
}