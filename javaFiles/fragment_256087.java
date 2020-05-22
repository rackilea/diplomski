State:<br>
        <select>
            <option><%
            ArrayList<edu.witc.Assignment03.model.States> states = (java.util.ArrayList)request.getAttribute("states");
               for (edu.witc.Assignment03.model.States state : states) { 
                   state.getStates();
               }%></option>
        </select><br>