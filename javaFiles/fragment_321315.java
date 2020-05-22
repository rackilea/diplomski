@Entity
class UserEntity {

    @Column(name = "pw")
    @Convert(converter = JPACryptoConverter.class)
    private String pw;
}