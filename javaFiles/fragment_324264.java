enum ImageType {
    MAIN
}
entity ImageTypeEntity {
    type ImageType
}
entity Image {
}
relationship OneToOne {
    Image{imageTypeEntity} to ImageTypeEntity
}