ServiceReference[] references = context.getServiceReferences(Factory.class.getName(),"(factory.name=my-factory)");

    if (references == null)
    System.out.println("No reference");


    else {

          System.out.println(references[0].toString());

          Factory factory =  context.getService(references[0]);
          x = factory.createComponentInstance(null); //here instantiating my component
          x.start(); //this starts my component service and executes start method


          System.out.println(x.getState());
          System.out.println(x.getInstanceName());


          x.dispose(); //this stops my component service and executes stop method

         }