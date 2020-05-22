@RequestMapping("/rating/{id}")
@ResponseBody 
public long getRatingInfo(@PathVariable("id") long id, HttpServletRequest req, HttpServletResponse res) throws Exception {

 List<Rating> ratings = myDao.findByPostId(id);
 long postobj = ratings.size() //use this code where you effectively need the # of entires.

 return ratings;
}