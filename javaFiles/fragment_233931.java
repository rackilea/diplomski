@(message: String, profile: Profile)

@main("") {
    <div class="form-group">
        <label class="col-lg-3 control-label" for="lastName">Last
            Name:</label>
        <div class="col-lg-4">

            <input type="text" class="form-control" name="lastname" value='@profile.getLastname'
            id="lastName" autocomplete="off" required
            data-bv-notempty-message="The last name is required" />
        </div>
    </div>
}