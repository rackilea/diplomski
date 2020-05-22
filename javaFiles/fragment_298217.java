@main("New Case Info") {
<fieldset>
    @b3.form(action = routes.CaseController.save()) {
    <div class="row">
        <div class="col-md-4">
            @b3.select(caseForm("caseType"),
                options = options(Case.typeOptions),
                '_id -> "type_selection",
                '_label -> "Case Type",
                '_default -> "-- Select a Type --")
        </div>
        <div class="col-md-3">
            @datePicker(caseForm("date"), '_label -> "Date", 'placeholder -> "mm/dd/yyyy")
        </div>
    </div>
 </fieldset>

}