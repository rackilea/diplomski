data class Cell(val id: Int, val childId: Int)

Observable.fromIterable(cells)
                .map(object: Function<Cell, Pair<Int, Cell>> {
                    var latest: Int? = null
                    var groupNumber: Int = 0

                    override fun apply(t: Cell): Pair<Int, Cell> {
                        if(t.id != latest) {
                            latest = t.id
                            groupNumber++
                        }
                        return Pair(groupNumber, t)
                    }

                })
                .groupBy { it.first }