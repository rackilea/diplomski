from l in lines      
let p = l.IndexOf('.')
where p >= 0
select new 
{
    FirstName = l.Substring(0, p), 
    LastName = l.Substring(p + 1)
}