String token = (String) session.getAttribute("token");
session.removeAttribute("token");

if (token != null && token.equals(request.getParameter("token"))) {
    // Valid, continue requesst.
} else {
    // Invalid, block request.
}