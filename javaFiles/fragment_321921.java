function SubmitForm()
{
    if(document.forms['contactus'].onsubmit())
    {
        showResultDiv();
        document.forms['contactus'].action='xxxx1';
        document.forms['contactus'].target='frame_result1';
        document.forms['contactus'].submit();

        // Changing the name of the inputs, to submit to location 2
        document.getElementById("input_administrator").name = "Second_Name_Administrator";

        document.forms['contactus'].action='xxxx2';
        document.forms['contactus'].target='frame_result2';
        document.forms['contactus'].submit();
    }
    return true;
}