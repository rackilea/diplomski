function UpdateCheckBoxStatus ()
{
    var CurrentChoice = $('#choiceSelector').val();

    $.ajax({
        url: "####YOUR JAVA APP URL####",
        data: { "selected": CurrentChoice },
        type: "post",
        dataType: "json",

        success: function (data)
        {
            SetCheckbox($('#changingCheckboxes').children("input:[type='checkbox']"), true);
            $.each(data.disabled, function ()
            {
               SetCheckbox($('#changingCheckboxes #' + this), false);
            });
        }
    });

}

/// Sets the checkbox to enabled or disabled
/// @param th Jquery reference of one or more checkboxes
/// @param usable True/False if the checkbox is enabled/disabled
function SetCheckbox (th, usable)
{
    if (usable)
        th.removeAttr("disabled");
    else if (!usable)
        th.attr("disabled", true);
}


$(function ()
{
    $('#choiceSelector').change(UpdateCheckBoxStatus);
    UpdateCheckBoxStatus(); //run for page load
});