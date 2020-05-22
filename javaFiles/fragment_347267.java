if(response=="existsnoadmin")
{
    alert(response);
    alert('The value obtained by the admin.java is ' +
          '<% request.getAttribute("rest") %>');
    // The value obtained by the admin.java is <% request.getAttribute("rest") %>
}