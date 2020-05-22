public static Result updateForm(String id) {
    Form<staffInfo> existingStaffForm = Form.form(staffInfo.class);
    staffInfo existingStaff = staffInfo.find.byId(id);

    if (existingStaff==null) {
        return badRequest("Oooops existingStaff not found in DB... ");
    }

    return ok(
            views.html.update.render(existingStaffForm.fill(existingStaff))
            );
}