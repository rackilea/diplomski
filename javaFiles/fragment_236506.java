public async Task<ActionResult> Index() {
    int a = 9;
    int b = 6;
    var result = await restfulClient.addition(a, b);
    return Content(result);
}