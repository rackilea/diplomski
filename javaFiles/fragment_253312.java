Wrapper wrapper;

    class Generic{

    }

    class Wrapper{
        Generic current;

        public void doSmth(Generic generic){
        }

        public Generic getCurrent(){
            return current;
        }
    }

    public void operation(){
        wrapper.doSmth(wrapper.getCurrent());
    }
}