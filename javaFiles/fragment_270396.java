@RequestMapping("/rating/{id}")
@ResponseBody 
public long getRatingInfo(@PathVariable("id") long id, HttpServletRequest req, HttpServletResponse res) throws Exception {

long postobj = myDao.countByPostId(id);
return postobj;
}