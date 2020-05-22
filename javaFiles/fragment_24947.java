//Determine if user is doing an export
boolean export = request.getParameter(TableTagParameters.PARAMETER_EXPORTING) != null;

if (export) {
    //Return entire list
} else {
    //Return paginated list
}