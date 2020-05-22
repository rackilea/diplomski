int eid;
String post = "";
int pr;
if(rs.next()){
    eid  = rs.getInt("id");
    post = rs.getString("position");
    pr = rs.getInt("priority"); 
}
if(id==eid)
{
    if((pos.equals(post))&&(pri==pr))
    {   
        out.print("<html><head>");
        out.print("<script type=\"text/javascript\">alert(" + "Details Authenticated" + ");</script>");
        out.print("</head><body></body></html>");
    }
}