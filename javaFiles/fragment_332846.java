sb.append("<p>"
                + "<div style='height:200px;width:500px;border:1px solid #ccc;font:16px/26px Georgia, Garamond, Serif;overflow:auto;'>"

                + "<form action='/Teacher/sendTest' method='POST'>"

                + "<input type='submit' value='Submit' action='/sendTest' method='post'>"

                + "<a>Current Test for students: " + testcont.getActiveTest() + "</a>"

                + "<fieldset><p>"
                + "<label>Select test</label>"
                + "<select name = 'selection'>"
                + currentTestOptions() // input
                + "</select></p></fieldset>"
                + "</form>"
                + "</div>"
                + "</p>");