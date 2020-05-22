private data class Thing(
        val name: String,
        val desc: String,
        val id: Long
) : EntityBase(id) {

    companion object {
        fun fromDto(dto: ThingDto) = Thing(
                name = dto.name,
                desc = dto.desc,
                id = dto.id 
        )
    }
}