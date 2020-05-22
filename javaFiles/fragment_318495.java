public void DoGet(HttpRequest request, HttpResponse response)
{
    var content = request.Params["content"];
    response.ContentType = "text/calendar";
    response.AddHeader("Content-length", content.Length.ToString());
    response.AddHeader("Content-disposition", "attachment; filename=event.ics");
    response.Write(content);
}