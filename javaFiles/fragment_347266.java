if(response=="existsnoadmin")
{
    alert(response);
    alert("The value obtained by the admin.java is " +request.getAttribute("rest"));
    out.println("The value obtained by the admin.java is " +request.getAttribute("rest"));
    alert("we have done in index.jsp");
}