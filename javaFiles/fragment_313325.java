in  first method...

 /*for (Course course : courses) {
        sb.append("<input type=\"checkbox\" name=\"prerequisite\" value=\"" + course.getCode() + "\">" + course.getCode() + "</input> <br />");
    }*/

in second method

String [] temp=request.getparameterbyValues("prerequisite");

 for (i=0;i<=temp.length;i++) {

        System.out.println(temp[i]);
    }