private void writeResponse(Object objectToWrite , ResourceResponse response){
        try {

            ObjectMapper mapper = new ObjectMapper();
            response.getWriter().write(mapper.writeValueAsString(objectToWrite));
        }
        catch (final JsonGenerationException e) {
            log.error(e.getMessage());
        } catch (final JsonMappingException e) {
            log.error(e.getMessage());
        } catch (final IOException e) {
            log.error(e.getMessage());
        }
    }