$("form").on(
    "submit",
    function ()
    {
        // disables <input type="submit" /> and <button type="submit"></button>
        $(this).find("[type='submit']").prop("disabled", true);
    }
);