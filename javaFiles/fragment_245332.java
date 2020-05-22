private data class Thing(
        val name: String,
        val desc: String
) : EntityBase() {

    companion object {

        fun fromDto(dto: ThingDto) : Thing {
            val thing = Thing(
                    name = dto.name,
                    desc = dto.desc)
            thing.id = dto.id;
            return thing;
        }

    }
}