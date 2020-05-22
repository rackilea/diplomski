@RequestMapping(headers = "Content-Type=application/json", value = "/postSth", method = RequestMethod.POST)
@ResponseStatus(value = HttpStatus.OK)
public String postSomething(@RequestBody String name){

       return model;
}

<div id='currentContent'>
        <!--Existing content -->
</div>
var ajaxResult = '';
$.ajax({
    type : POST,
    url: "postSth",
    async:false}).then(function(data){
        //DIV ID here would be the ID which you need to have in your page to append the HTML content.
        //if you want to completely reload the page then use the id where your current contents are displayed
        //Inside your somenewjsp.jsp you can write your jquery codes to access the variable ajaxResult on document ready
        ajaxResult = data;
        $('#currentContent').load('/somenewjsp.jsp');
    });
});