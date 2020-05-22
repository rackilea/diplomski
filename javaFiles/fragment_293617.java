public abstract class BaseModel<M> {

        private List<M> modelList;

        public List<M> getModelList() {
            return modelList;
        }

        public void setModelList(List<M> modelList) {
            this.modelList = modelList;
        }
    }