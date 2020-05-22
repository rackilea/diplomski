try{
             Class< ? > c = Class.forName( "com.kaissersoft.test.objective.one.three.enums.Days$8" );

            Field[] fs= c.getDeclaredFields();
            for( Field f: fs ){
           System.out.println( f.toString() );
            }
        }catch( ClassNotFoundException cne){
          cne.printStackTrace();
        }


// Output
static final int[] com.kaissersoft.test.objective.one.three.enums.Days$8.$Switch
Map$com$kaissersoft$test$objective$one$three$enums$Days