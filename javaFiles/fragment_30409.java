chairEntity.getImages().add(new ImageEntity(...));
chairRepository.saveAndFlush(chairEntity);
chairEntity.getImages().stream().forEach(imageEntity -> {
  imageEntity.setDescription("some other description");
}
chairRepository.save(chairEntity); // crashes