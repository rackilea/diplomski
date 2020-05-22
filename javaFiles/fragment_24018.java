Collection<? extends Human> results = ... ;
 for(Human h : results) {

    if (h instanceof User) {
       User u = (User) h; // this is safe
       // ...
    } else if (h instanceof Man) {
       Man m = (Man) h; // this is safe
       // ...
    } else if (row instanceof Woman) {
       Woman w = (Woman) h; // this is safe
       // ...
    }

 }