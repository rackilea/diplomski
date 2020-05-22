public class MyFirstValidator implements ChainedValidator{
        //This CoR implementation has also a 'Composite' background
        ChainedValidator nextValidator;

        @Override
        private void doValidate(Request request) throws ValidationException
        {
              if(badSituation){
                    //throw validation exception
              }
        }

        @Override
        public void doChainValidate(Request request) throws ValidationException
        {//This method can be moved to a parent abstract class
              doValidate(request);
              if(nextValidator!=null){
                    nextValidator.doChainValidate(request);
              }
        }

        private void attachValidator(ChainedValidator newValidator) throws ValidationException
        {//same as previous method
              if(nextValidator!=null){
                    nextValidator.attachValidator(request);
              }else{
                    nextValidator=newValidator;
              }
        }
        //setters & other methods
    }