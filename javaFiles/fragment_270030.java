public <T extends BaseDTO> List<T> populateDTOList(List<T> unpopulatedDTOs, Class<T> clazz, String restPath) {
    List<T> populatedDTOs = new ArrayList<T>();

    for (T unpopulatedDTO : unpopulatedDTOs) {
        T populatedDTO = webResource.path(restPath)
                            .path(unpopulatedDTO.getId().toString())
                            .type(MediaType.APPLICATION_XML)
                            .get(ClientResponse.class)
                            .getEntity(clazz);

        populatedDTOs.add(populatedDTO);
    }

    return populatedDTOs;
}