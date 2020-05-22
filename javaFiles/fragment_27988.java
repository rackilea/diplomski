private fun getPosition(entityId: Int): Int {
    for (i in list.indices) {
        if (list[i].entity_id == entityId) { //match with your id
            return i
        }
    }
    return -1
}