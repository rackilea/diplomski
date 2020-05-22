val floorL = viewsByLeftEdge.floorKey(left)
val ceilingL = viewsByLeftEdge.ceilingKey(left)
val nearestL = when {
    floorL == null -> ceilingL
    ceilingL == null -> floorL
    ceilingL - left < left - floorL -> ceilingL
    else -> floorL
}

if (nearestL in left - 50 .. left + 50)
    x = nearestL