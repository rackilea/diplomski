try{
           SpringApplication.run(Application.class, args).close();;
        }
        catch(Exception ex){
            System.out.println("Going to exit");
            System.exit(-1);
        }