if ((name != null) && (name.length() > 0) ){

 session.setAttribute("username", name);

out.println("The username " + name  );


}else {
out.println("The username " + (String) session.getAttribute("username") );
}





if ((address != null) && (address.length() > 0)){
session.setAttribute("address", address);

  out.println("The address " + adress );

}else {
out.println("The address " + (String) session.getAttribute("address") );
}