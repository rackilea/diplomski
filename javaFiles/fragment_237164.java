public void validateRequiredFields(JSONObject jsonObject, List<String> requiredFields) throws ParserException, Exception {
        if (log.isDebugEnabled()) {
            log.debug("Entering validateForRequiredFields");
        }
        List<String> missingFields = new ArrayList<String>();
        try {
            if (requiredFields != null) {
                for (String requiredField : requiredFields) {
                    if (ifObjectExists(jsonObject, requiredField)) {
                        if (StringUtils.isEmpty(jsonObject.getString(requiredField))) {
                            missingFields.add(requiredField);
                        }
                    } else {
                        missingFields.add(requiredField);
                    }
                }
            }
            if (missingFields != null && missingFields.size() > 0) {
                throw new Exception(missingFields);
            }
        } catch (JSONException e) {
            throw new ParserException("Error occured in validateRequiredFields", e);
        }
    }