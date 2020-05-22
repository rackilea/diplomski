@helper.form(action = routes.Application.save(), 'id -> "userForm") {
<fieldset>
    @for(applicant <- applicants) {
    <hr>
    <h3>@applicant.getName()</h3>
            <h4>Decision</h4>

            @helper.input(userForm("status")) { (id,name,value,args) =>
            <div class="radio">
                <label> <input type="radio"
                    name="name_@applicant.getId" id="option1_id_@applicant.getId"
                    value="value1" @toHtmlArgs(args)>Hire
                </label>
            </div>
            <div class="radio">
                <label> <input type="radio"
                    name="name_@applicant.getId" id="option2_id_@applicant.getId"
                    value="value2" @toHtmlArgs(args)> Fire
                </label>
            </div>
            <div class="radio">
                <label> <input type="radio"
                    name="name_@applicant.getId" id="option3_id_@applicant.getId"
                    value="value3" @toHtmlArgs(args)> Maybe
                </label>
            </div>
            }
    }
</fieldset>
<div class="actions">
    <input type="submit" value="Save" class="btn btn-primary">
</div>
}