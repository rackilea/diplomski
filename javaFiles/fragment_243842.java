for (AuthorDto authorDto : dataAuthorDto) {
    Author author = authorDao.findByName(authorDto.getName());
    if (null == author) {
        author = new Author();
        BeanUtils.copyProperties(authorDto, author);
    }
    dataAuthor.add(author);
}