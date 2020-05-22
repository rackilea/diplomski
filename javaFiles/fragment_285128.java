public static <D, T> List<D> entityToDTO(final Collection<T> sourceList, Class<D> destinationCLass) {
        if (Objects.isNull(sourceList)) {
            return null;
        }
        return sourceList.stream().map(entity -> modelMapper.map(entity, destinationCLass))
            .collect(Collectors.toList());

   }