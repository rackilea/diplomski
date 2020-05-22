rs = st.executeQuery("select * from activities where type='müzik'");
                        while (rs.next()) {

                            out.println("<tr>");
                            out.println("<form action='reservations.jsp'>");
                            out.println("<td>" + rs.getString("id") + "<input type='hidden' name='id' value='" + td.getString("id")+"'></td>");
                            out.println("<td><input type='submit' value='Submit'></form></b></td>");
                            out.println("</td></tr>");

                        }
                        st.close();