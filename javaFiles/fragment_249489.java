<form name ="createLabs" ACTION="CreateLab" method="post" onsubmit="return validateForm()">

        Subject: <select name="subject_id">
        <%
        for(int i=0; i<list1.length; i++)  
        {
            //for(int m=0; m<list2.length;i++)
            //{
                out.println("<option value="+list1[i]+"> "+list2[i]+" </option>");

        //}
            out.println("list1:"+list1[0]);
            }
            %>
        </select><br><br>
        Capacity: <input type="text" name="capacity"/><br /><br>
        <input type="hidden" name="spots_left"/>
        Day: <input type="text" name="day"/><br /><br>
        Time (HH:MM:SS): <input type="time" name="time"/><br /><br>
        Room: <input type="text" name="room"/><br /><br>
        <input type="submit" value="Submit" name="Submit"   />

    </form>