@RequestMapping(value = {"/delete/search/}, method = 
                  RequestMethod.DELETE)
@ResponseBody
public Integer deleteUser(Demo demo) {
     demo.getId_Search();
}