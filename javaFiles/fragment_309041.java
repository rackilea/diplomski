@Transactional
public Owner getOwner(Integer id) {
    Owner owner = ownerRepository.findOne(id);
    // You can access owner.getBooks() content here because the transaction is still open
    return owner;
}