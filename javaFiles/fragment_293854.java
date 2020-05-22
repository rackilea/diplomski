answer = new ArrayList ();
 int i = 0, k = 0;
 while (i < papers.size () &&  k < papers2.size ())
 {
     // add papers.get (i);
     // add papers2.get (k);
     i++;
     k++;
 }

 // this will not be entered if completely looped through papers
 while (i < papers.size ())
 {
     // add papers.get (i);
     i++;
 }

 // this will not be entered if completely looped through papers2
 while (k < papers2.size ())
 {
     // add papers2.get (i);
     k++;
 }