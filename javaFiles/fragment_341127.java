$(document).ready(function()
{
    document.getElementById("markets").onchange =  function()
    { 
        var market = $("select[id='markets'").find('option:selected').text();

        $.ajax({
            url: "/getsector?market="+market,
            type: "GET",
            success: function(response) 
            {
                console.log("sucess!");
            },
            error: function(e){
                console.log("ERROR: ", e);
            }
        });
    }
}); 

@RequestMapping(value = "/getsector", method = RequestMethod.GET)
public @ResponseBody String getSector(@RequestParam("market")String market) throws JsonGenerationException, JsonMappingException, IOException
{
  .... your logic.
}