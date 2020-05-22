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
            .flatMapSingle { group ->
                return@flatMapSingle group.reduce(Pair(group.key!!, mutableListOf())) { acc: Pair<Int, MutableList<Int>>, el: Pair<Int, Cell> ->
                    acc.second.add(el.second.childId)
                    return@reduce acc
                }
            }.toList()
            .subscribe({
                Log.d("TAG", it.toString())
            }, { e -> e.printStackTrace() })