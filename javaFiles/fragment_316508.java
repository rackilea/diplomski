public class Builders
{

    public static abstract class AbstractActionModel
    {
        public abstract void getModel();

        public abstract void getAction();
        public abstract void setAction(String action);
    }

    public static class ConcreteActionModel extends AbstractActionModel
    {
        public void getModel() {};

        public void getAction() {};
        public void setAction(String action) {};
    }

    public static class ModelBuilder
    {
        AbstractActionModel model;

        Map<String, Class<? extends AbstractActionModel>> register = new HashMap<String, Class<? extends AbstractActionModel>>();
        public void register(String key, Class<? extends AbstractActionModel> c) {register.put("concrete", ConcreteActionModel.class);}

        public ModelBuilder choose(String key) throws InstantiationException, IllegalAccessException {          
            model = register.get(key).newInstance();
            return this;
        }

        public ModelBuilder action(String action) {
            model.setAction(action);
            return this;
        }

        public AbstractActionModel build() {
            return model;
        }
    }

    public static void main(String[] args) throws Exception
    {       
        ModelBuilder mb = new ModelBuilder();
        mb.register("concrete", ConcreteActionModel.class);
        mb.choose("concrete").action("sth").build();
    }
}