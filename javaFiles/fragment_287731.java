public class JSONArrayObjectWrapper extends DefaultObjectWrapper {

    @Override
    public TemplateModel handleUnknownType (Object obj) throws TemplateModelException {

        if (obj instanceof JSONArray) {
            return new JSONArraySequenceModel((JSONArray) obj);
        }

        return super.handleUnknownType(obj);
    }


    public class JSONArraySequenceModel implements TemplateSequenceModel {

        private JSONArray jsonArray;

        public JSONArraySequenceModel(JSONArray jsonArray) {
            this.jsonArray = jsonArray;
        }

        @Override
        public TemplateModel get(int index) throws TemplateModelException {
            TemplateModel model = null;
            try {

                model = wrap(jsonArray.get(index));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return model;
        }

        @Override
        public int size() throws TemplateModelException {
            return jsonArray.length();
        }

    }


}