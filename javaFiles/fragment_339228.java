// create a new Movie called "one"
Movie one = new Movie();

// at this point, one.title is still null

// set the title to "I am title"
one.title = "I am title";

// call playIt, which in turn ...
one.playIt();
   // sets the title to something else again
   => this.title = "I am title of movie";