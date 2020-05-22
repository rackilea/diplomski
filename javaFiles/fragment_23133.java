Set<Integer>  sqlrno = new HashSet<Integer>();
Set<Integer>  accessrno = new HashSet<Integer>();
Set<Integer> result = null;
if(sqlrNo.size() > accessrno.size()){
 result = new HashSet<Integer>(sqlrno);
 result.removeAll(accessrno);
}else{
 result = new HashSet<Integer>(accessrno);
 result.removeAll(sqlrno);
}