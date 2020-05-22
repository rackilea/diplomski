final Label jsonLabel = new Label("jsonLabel", Model.of(""));
jsonLabel.setOutputMarkupId(true);
AjaxLink<Void> jsonData = new AjaxLink<Void>("jsonData") {

        @Override
        public void onClick(AjaxRequestTarget target) {
            File jsonFile;
            try {
                jsonFile = new File(fileLocation);

                ObjectMapper mapper = new ObjectMapper();        
                JsonNode jsonNode = mapper.readValue(jsonFile, JsonNode.class);
                // just update the Label's model and re-paint it
                jsonLabel.setModelObject(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode));
                target.add(jsonLabel);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    add(jsonData, jsonLabel);