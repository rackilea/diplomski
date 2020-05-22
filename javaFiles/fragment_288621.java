lines.Select(l => new {l, p = l.IndexOf('.') })
     .Where(_ => _.p >= 0)
     .Select(_ => new 
         { 
             FirstName = _.l.SubString(0, _.p), 
             LastName = _.l.SubString(_.p + 1) 
         })