State:<br>
        <select>
            <%
            edu.witc.Assignment03.model.States states = request.getAttribute("states");
            if(states!=null){   
            for (String state : states.getStates()) { 
                   out.println("<option>"+state+"</option>");
               }
             }else{
                 System.out.print("states is null");
             }
             %>
        </select><br>