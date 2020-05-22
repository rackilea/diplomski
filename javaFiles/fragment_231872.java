IObservableValue target = ViewersObservables.observeSingleSelection(c_viewer);
IObservableValue model = BeansObservables.observeValue(getInputObject(), "id");

    UpdateValueStrategy u = new UpdateValueStrategy().setConverter(new IConverter() {

        @Override
        public Object getFromType() {
            return long.class;
        }

        @Override
        public Object getToType() {
            return int.class;
        }

        @Override
        public Object convert(Object fromObject) {
            return Integer.parseInt(fromObject.toString());
        }
    });
    ctx.bindValue(target, model, null, u);