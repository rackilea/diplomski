Person // model
   update();

View
   modelUpdated()
       println(Person.name); ...

Controller
     main()
         while( input = getInput() )
             person.update(...);
             view.modelUpdated();