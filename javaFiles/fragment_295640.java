function searchViaAjax(id) { 
 $.ajax({ 
 type : "GET", 
 url : "/search/api/getSearchResult/"+id, 
 timeout : 100000, 
 success : function(id) { 
 console.log("SUCCESS: ", id); 
 display(id); 
 alert(response); 
}, 
error : function(e) { 
console.log("ERROR: ", e); 
display(e); 
}, 
done : function(e) { 
console.log("DONE"); 
} 
}); 
} 

@Controller 
public class AjaxController { 

@ResponseBody 
@RequestMapping(value = "/search/api/getSearchResult/{id}") 
public String getSearchResultViaAjax(@PathVariable(value = "id") Integer id) 
{ 
 return String.valueOf(id); 
} 
}